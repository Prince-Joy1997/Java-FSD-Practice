package in.stackroute.ust.service;

import in.stackroute.ust.domain.Todo;

import java.util.List;

public interface TodoService {

    Todo save(Todo todo);
    void deleteById(int id);
    Todo findById(int id);
    List<Todo> findAll();

}
