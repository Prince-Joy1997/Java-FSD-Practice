package in.stackroute.ust.controller;

import in.stackroute.ust.domain.Todo;
import in.stackroute.ust.dto.TodoDto;
import in.stackroute.ust.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private Logger logger = LoggerFactory.getLogger(TodoController.class);

    private TodoService todoService;
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    private TodoDto convertToDo(Todo todo){

        return new TodoDto(todo.getId(), todo.getReminder(), todo.isCompleted());
    }

    private Todo convertToEntity(TodoDto todoDto){
        return new Todo(todoDto.id(), todoDto.reminder(),todoDto.completed());
    }
    // POST     /api/v1/todos
    @PostMapping("")
    public ResponseEntity<TodoDto> add(@RequestBody TodoDto todoDto){
        final var todo = convertToEntity(todoDto);
        final var createdTodo = todoService.save(todo);
        final var dto = convertToDo(createdTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
    // GET      /api/v1/todos

    @GetMapping("")
    public ResponseEntity<List<TodoDto>> getall(){
        final var todos = todoService.findAll();

        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        if (todos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        final var todoDtos = todos.stream().map(todo -> convertToDo(todo)).collect(Collectors.toList());
        return  ResponseEntity.status(HttpStatus.OK).body(todoDtos);
    }
    // GET      /api/v1/todos/{id}

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getById(@PathVariable int id){
        final var todo = todoService.findById(id);

        if (todo == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        final var todoId =todo;
        final var todoDto = convertToDo(todoId);
        return ResponseEntity.status(HttpStatus.OK).body(todoDto);
    }
    // PUT      /api/v1/todos/{id}

    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> update(@PathVariable int id, @RequestBody TodoDto todoDto){
        final var todo = todoService.findById(id);
        if (todo == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        todo.setReminder(todoDto.reminder());
        todo.setCompleted(todoDto.completed());
        final var res = todoService.save(todo);
        return ResponseEntity.status(HttpStatus.OK).body(convertToDo(res));
    }
    // DELETE   /api/v1/todos/{id}

    @DeleteMapping("/{id}")
    public ResponseEntity<TodoDto> deleteById(@PathVariable int id){
        final var todo = todoService.findById(id);
        if (todo == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        todoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
