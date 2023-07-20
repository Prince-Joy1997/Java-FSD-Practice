package in.stackroute.ust.movie.customer.service;

import in.stackroute.ust.movie.customer.domain.Customer;

import java.util.Optional;

public interface CustomerService {
    Customer createCustomer(Customer customer);

    Optional<Customer> findByEmailAndPassword(String email, String password);

    Optional<Customer> findById(int id);

    Optional<Customer> findByEmail(String email);
}
