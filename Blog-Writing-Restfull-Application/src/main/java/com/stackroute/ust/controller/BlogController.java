package com.stackroute.ust.controller;

import com.stackroute.ust.domain.Blog;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    List<Blog> blogList = new ArrayList<>();

    @GetMapping("")
    public List<Blog> getAll(){
        return blogList;
    }

    @PostMapping("/add")
    public Blog addBlog(@RequestBody Blog blog){
        blogList.add(blog);
        return blog;
    }

    @PutMapping("/update/{id}")
    public Blog update(@PathVariable int id, @RequestBody Blog blog){
        blogList.remove(blogList.stream().filter(blogList -> blogList.id() == id).findFirst().orElseThrow());
        blogList.add(blog);
        return blog;
    }

    @DeleteMapping("/delete/{id}")
    public List<Blog> deleteById(@PathVariable int id){
        blogList.remove(blogList.stream().filter(blogList -> blogList.id() == id).findFirst().orElseThrow());
        return blogList;
    }
}
