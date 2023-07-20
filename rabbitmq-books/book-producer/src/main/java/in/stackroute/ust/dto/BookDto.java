package in.stackroute.ust.dto;

import java.io.Serializable;
import java.util.List;

public record BookDto(String name, List<String> bookName) implements Serializable {
    @Override
    public String toString() {
        return "BookDto{" +
                "name='" + name + '\'' +
                ", bookName=" + bookName +
                '}';
    }
}
