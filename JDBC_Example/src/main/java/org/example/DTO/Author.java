package org.example.DTO;

import lombok.*;

import java.time.LocalDate;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//public class Author {
//
//    private int authorId;
//
//    private String authorName;
//
//    private String authorEmail;
//
//    private  LocalDate joinDate;
//
//}

public record Author(int authorId, String authorName, String authorEmail, LocalDate joinDate) {

}

