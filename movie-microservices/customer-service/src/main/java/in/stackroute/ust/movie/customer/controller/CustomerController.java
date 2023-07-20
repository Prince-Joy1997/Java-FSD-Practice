package in.stackroute.ust.movie.customer.controller;

import in.stackroute.ust.movie.customer.domain.Customer;
import in.stackroute.ust.movie.customer.dto.CustomerDto;
import in.stackroute.ust.movie.customer.dto.LoginDto;
import in.stackroute.ust.movie.customer.exceptions.CustomerAlreadyExistException;
import in.stackroute.ust.movie.customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import java.util.Optional;

import static in.stackroute.ust.movie.customer.utility.EntityDtoUtil.toDto;
import static in.stackroute.ust.movie.customer.utility.EntityDtoUtil.toEntity;


@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    private Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto dto){
        Optional<Customer> customer = customerService.findByEmailAndPassword(dto.email(), dto.password());
        if(customer.isPresent()){
            logger.error("createCustomer: Customer with email {} or password {} already exists", dto.email(),dto.password());
            throw new CustomerAlreadyExistException(String.format("Customer with email %d already exists", dto.email()), ServletUriComponentsBuilder.fromCurrentRequest().toUriString());
        }
        Customer res = customerService.createCustomer(toEntity(dto));
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(res.getId()).toUri()).body(toDto(res));
    }

    @PostMapping("/login")
    public ResponseEntity<CustomerDto> loginCustomer(@Valid @RequestBody LoginDto dto){
        var optional = customerService.findByEmailAndPassword(dto.email(),dto.password());
        if(optional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toDto(optional.get()));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable int id) {
        var optional = customerService.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toDto(optional.get()));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<CustomerDto> getCustomerByEmail(@PathVariable String email) {
        var optional = customerService.findByEmail(email);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toDto(optional.get()));
    }

}
