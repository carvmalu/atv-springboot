package biblioteca.biblioteca.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroPostPutDto {
    @JsonProperty("nomeLivro")
    @NotBlank(message = "Nome do livro não pode ser vazio")
    private String nomeLivro;

    @JsonProperty("nomeAutor")
    @NotBlank(message = "Nome do autor do livro não pode ser vazia")
    private String nomeAutor;
}