package in.stackroute.ust.movie.dto;

import java.time.LocalDateTime;

public record ErrorDto(String message, LocalDateTime timestamp, String path, int status) {
}
