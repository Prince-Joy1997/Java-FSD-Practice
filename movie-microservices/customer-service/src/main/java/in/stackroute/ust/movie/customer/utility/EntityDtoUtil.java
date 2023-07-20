package in.stackroute.ust.movie.customer.utility;

import in.stackroute.ust.movie.customer.domain.Customer;
import in.stackroute.ust.movie.customer.dto.CustomerDto;

public class EntityDtoUtil {

    public static Customer toEntity(CustomerDto dto){
        return new Customer(dto.id(), dto.name(), dto.email(),dto.password());
    }

    public static CustomerDto toDto(Customer customer){
        return new CustomerDto(customer.getId(), customer.getName(), customer.getEmail(), customer.getPassword());
    }
}
