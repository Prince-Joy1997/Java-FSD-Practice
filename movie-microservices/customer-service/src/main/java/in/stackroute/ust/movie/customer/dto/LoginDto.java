package in.stackroute.ust.movie.customer.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public record LoginDto(@NotEmpty @NotBlank @Email String email,@NotBlank @NotEmpty String password) {
}
