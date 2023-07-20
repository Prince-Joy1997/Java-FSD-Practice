package in.stackroute.ust.service;

import in.stackroute.ust.domain.User;

import java.util.Optional;

public interface UserPersistenceService
        extends GenericPersistenceService<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);
}
