package org.example.controller;

import org.example.domain.Trainee;
import org.example.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TraineeController {

    @Autowired
    private TraineeRepository traineeRepository;

    @PostMapping("/add")
    public ResponseEntity<Trainee> addTrainee(@RequestBody Trainee trainee){
        return ResponseEntity.status(HttpStatus.CREATED).body(traineeRepository.save(trainee));
    }

    @GetMapping("/trainee")
    public ResponseEntity<List<Trainee>> getAllTrainee(){
        return ResponseEntity.status(HttpStatus.OK).body(traineeRepository.findAll());
    }

    @GetMapping("/trainee/{id}")
    public ResponseEntity<Trainee> getTraineeById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(traineeRepository.findById(id).get());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Trainee> updateTrainee(@RequestBody Trainee trainee, @PathVariable int id){
        var res = traineeRepository.findById(id).get();
        res.setId(trainee.getId());
        res.setName(trainee.getName());
        res.setGender(trainee.getGender());
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Trainee> deleteTrainee(@PathVariable int id){
        traineeRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/name")
    public ResponseEntity<Trainee> getByName(@RequestParam String name){
        return ResponseEntity.status(HttpStatus.OK).body(traineeRepository.findByName(name));
    }
}
