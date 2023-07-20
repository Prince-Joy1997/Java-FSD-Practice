package in.stackroute.ust.service;

import in.stackroute.ust.domain.Todo;
import in.stackroute.ust.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    public TodoServiceImpl(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }
    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void deleteById(int id) {
       todoRepository.deleteById(id);
    }

    @Override
    public Todo findById(int id) {
        return todoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Todo> findAll() {

        return todoRepository.findAll();
    }
}
