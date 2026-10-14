package biblioteca.biblioteca.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroResponseDto {
    @JsonProperty("IBSN")
    private Long IBSN;

    @JsonProperty("nomeLivro")
    private String nomeLivro;

    @JsonProperty("nomeAutor")
    private String nomeAutor;
}