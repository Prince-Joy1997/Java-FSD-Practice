package in.stackroute.ust.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Author {

    private int authorId;

    private String authorName;

    private String authorEmail;

    private LocalDate joinDate;
}
