package in.stackroute.ust.service;

import java.util.List;
import java.util.Optional;

public interface GenericPersistenceService<T, ID> {

    T save(T entity);

    T update(T entity);

    Optional<T> findById(ID id);

    List<T> findAll();

    void deleteById(ID id);
}
