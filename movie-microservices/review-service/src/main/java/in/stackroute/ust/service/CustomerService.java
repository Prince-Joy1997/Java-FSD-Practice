package in.stackroute.ust.service;

import in.stackroute.ust.dto.CustomerDto;

import java.util.Optional;

public interface CustomerService {
    Optional<CustomerDto> findByEmail(String email);
}
