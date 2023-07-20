package in.stackroute.ust.controller;

import in.stackroute.ust.domain.ToDo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    private List<ToDo> toDoList = new ArrayList<>();

    @GetMapping("")
    public List<ToDo> getAll(){

        return toDoList;
    }

    @GetMapping("/{id}")
    public ToDo getById(@PathVariable int id){
        return toDoList.stream().filter(toDoList -> toDoList.id() == id).findFirst().orElseThrow();
    }

    @PostMapping("/add")
    public ToDo create(@RequestBody ToDo toDo){
        toDoList.add(toDo);
        return toDo;
    }

    @PutMapping("/update/{id}")
    public ToDo change(@PathVariable int id, @RequestBody ToDo toDo){
        toDoList.remove(toDoList.stream().filter(toDoList->toDoList.id() == id).findFirst().orElseThrow());
        toDoList.add(toDo);
        return toDo;
    }

    @DeleteMapping("/delete/{id}")
    public List<ToDo> deleteById(@PathVariable int id){
        toDoList.remove(toDoList.stream().filter(toDoList->toDoList.id() == id).findFirst().orElseThrow());
       return toDoList;
    }

}
