package in.stackroute.ust.movie.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record MovieDto(int id, @NotNull @NotEmpty @NotBlank String title) {
}
