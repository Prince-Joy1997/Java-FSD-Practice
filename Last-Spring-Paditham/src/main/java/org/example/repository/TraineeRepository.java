package org.example.repository;

import org.example.domain.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraineeRepository extends JpaRepository<Trainee,Integer> {

    Trainee findByName(String name);
}
