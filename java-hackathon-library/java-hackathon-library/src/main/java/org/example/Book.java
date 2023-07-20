package org.example;

public class Book {
    private int bookIsbnNo;
    private String author;
    private String publisher;

    public int getBookIsbnNo() {
        return bookIsbnNo;
    }

    public void setBookIsbnNo(int bookIsbnNo) {
        this.bookIsbnNo = bookIsbnNo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
