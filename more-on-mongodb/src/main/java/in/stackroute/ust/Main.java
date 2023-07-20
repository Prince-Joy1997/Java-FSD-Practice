package in.stackroute.ust;

import in.stackroute.ust.domain.Batch;
import in.stackroute.ust.domain.Student;
import in.stackroute.ust.repository.BatchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(Main.class);

    @Autowired
    private BatchRepository batchRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Set<Student> students = Set.of(new Student("John", "john.doe"),
                new Student("Jane", "jane.doe"),
                new Student("Jack", "jack.doe"));
        Batch batch = new Batch("CSE101", "Java Programming", students);

//        logger.debug("Deleting all records in the collections");
//        batchRepository.deleteAll();

        logger.debug("Saving batch: {}", batch);
        batchRepository.save(batch);

        logger.debug("Reading all batch data");
        batchRepository.findAll().forEach(b -> logger.debug("{}", b));

        logger.debug("Reading batch by code");
        batchRepository.findByCode("CSE101").ifPresent(b -> logger.debug("{}", b));

//        logger.debug("Delete the batch.");
//        batchRepository.delete(batch);

        logger.debug("Ending the application");
    }
}