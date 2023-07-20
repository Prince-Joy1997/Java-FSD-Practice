package in.stackroute.dto;

import java.time.LocalDate;
import java.util.List;

public record NewOrderDto(
        String orderId,
        LocalDate orderDate,
        List<String> items,
        int total
) {
}
