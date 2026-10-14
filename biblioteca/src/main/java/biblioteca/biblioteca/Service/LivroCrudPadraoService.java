package biblioteca.biblioteca.Service;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;
import biblioteca.biblioteca.Model.Livro;
import biblioteca.biblioteca.Repository.LivroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LivroCrudPadraoService implements LivroCrudService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    livroRepository livroRepository;

    @Override
    public LivroResponseDto criarLivro(LivroPostPutDto LivroPostPutDto) {
        Livro livro = modelMapper.map(livroPostPutDto, Livro.class);
        return modelMapper.map(livroRepository.save(livro), LivroResponseDto.class);
    }

    @Override
    public List<LivroResponseDto> buscarTodosLivros() {
        return livroRepository.findAll()
                .stream()
                .map(livro -> modelMapper.map(livro, LivroResponseDto.class))
                .toList();
    }

    @Override
    public AutorResponseDto buscarAutor(Long id) {
        return modelMapper.map(obterAutorExistente(id), AutorResponseDto.class);
    }

    @Override
    public AutorResponseDto atualizarAutor(Long id, AutorPostPutDto autorPostPutDto) {
        Autor autor = obterAutorExistente(id);
        autor.setNomeAutor(autorPostPutDto.getNomeAutor());
        autor.setNacionalidade(autorPostPutDto.getNacionalidade());
        return modelMapper.map(autorRepository.save(autor), AutorResponseDto.class);
    }

    @Override
    public void removerAutor(Long id) {
        // delete(entidade) permite que o cascade da relação remova também os livros do autor
        autorRepository.delete(obterAutorExistente(id));
    }

    // id inexistente = 404
    private Autor obterAutorExistente(Long id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado"));
    }
}