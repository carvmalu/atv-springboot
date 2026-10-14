package biblioteca.biblioteca.Service;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;

import java.util.List;

public interface LivroCrudService {

    LivroResponseDto criarLivro(LivroPostPutDto LivroPostPutDto);

    List<LivroResponseDto> buscarTodosLivros();

    LivroResponseDto buscarLivro(Long IBSN);

    LivroResponseDto atualizarLivro(Long IBSN, LivroPostPutDto LivroPostPutDto);

    void removerLivro(Long IBSN);
}