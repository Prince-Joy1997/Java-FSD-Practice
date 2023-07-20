package in.stackroute.ust.repository;

import in.stackroute.ust.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
