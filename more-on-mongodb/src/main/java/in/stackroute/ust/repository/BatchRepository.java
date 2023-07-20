package in.stackroute.ust.repository;

import in.stackroute.ust.domain.Batch;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface BatchRepository extends MongoRepository<Batch, String> {

    Optional<Batch> findByCode(String code);

}
