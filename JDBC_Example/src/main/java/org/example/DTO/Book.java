package org.example.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Book {
//
//    private int book_id;
//    private int author_id;
//    private String book_title;
//    private double book_price;
//}

public record Book(int bookId, int authorId, String bookTitle, String bookPrice) {
}
