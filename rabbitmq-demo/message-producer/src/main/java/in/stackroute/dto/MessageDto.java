package in.stackroute.dto;

import java.io.Serializable;
import java.time.LocalTime;

public record MessageDto(LocalTime time,String message,int statusCode) implements Serializable {
    @Override
    public String toString() {
        return "MessageDto{" +
                "time=" + time +
                ", message='" + message + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }
}
