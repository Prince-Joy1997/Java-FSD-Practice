package in.stackroute.ust.Dto;

import java.util.List;

public record BookDto(String name, List<String> bookName) {
    @Override
    public String toString() {
        return "BookDto{" +
                "name='" + name + '\'' +
                ", bookName=" + bookName +
                '}';
    }
}
