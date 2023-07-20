package in.stackroute.springrestjpacodingchallenge.controller;

import in.stackroute.springrestjpacodingchallenge.domain.Feedback;
import in.stackroute.springrestjpacodingchallenge.domain.Product;
import in.stackroute.springrestjpacodingchallenge.repository.FeedbackRepository;
import in.stackroute.springrestjpacodingchallenge.repository.ProductRepository;
import in.stackroute.springrestjpacodingchallenge.service.FeedbackService;
import in.stackroute.springrestjpacodingchallenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/")
public class ProductsController {

//

    @Autowired
    ProductRepository productRepository;
    @Autowired
    FeedbackRepository feedbackRepository;

    @GetMapping("")
    public ResponseEntity<List<Product>> getAll(){
        final var out = productRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(out);
    }

    @PostMapping("{pid}/feedbacks")
    public ResponseEntity<Feedback> createFeedback(@PathVariable int pid, @RequestBody Feedback feedback){
        var prdt = productRepository.findById(pid).get();
        if(prdt.getProductId() == pid){
            return ResponseEntity.status(HttpStatus.OK).body(feedbackRepository.save(feedback));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
