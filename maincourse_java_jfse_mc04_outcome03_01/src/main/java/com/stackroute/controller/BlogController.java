package com.stackroute.controller;


import com.stackroute.domain.Blog;
import com.stackroute.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/* Add annotation to declare this class as REST Controller */
@RestController
@RequestMapping("/api/v1")
public class BlogController {

    private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

//    private BlogDto convertBlog(Blog blog) {
//        return new BlogDto(blog.getBlogId(), blog.getBlogTitle(), blog.getAuthorName(), blog.getBlogContent());
//    }

//    private Blog convertToEntity(BlogDto blogDto) {
//        return new Blog(blogDto.blogId(), blogDto.blogTitle(), blogDto.authorName(), blogDto.blogContent());
//    }

    /* Provide implementation code for these methods */

    /*This method should save blog and return savedBlog Object */
    @PostMapping("/blog")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        //final var blogs = convertToEntity(blog);
        var result = blogService.getBlogById(blog.getBlogId());
        if (result != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        final var createblog = blogService.saveBlog(blog);
        //final var dto = convertBlog(createblog);
        return ResponseEntity.status(HttpStatus.CREATED).body(createblog);
    }

    /*This method should fetch all blogs and return the list of all blogs */
    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = blogService.getAllBlogs();

        if (blogs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //final var blogdtos = blogs.stream().map(blog -> convertBlog(blog)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.FOUND).body(blogs);
    }

    /*This method should fetch the blog taking its id and return the respective blog */
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable int id) {
        final var blog = blogService.getBlogById(id);

        if (blog == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //final var blogId = blog;
        //final var blogdto = convertBlog(blogId);
        return ResponseEntity.status(HttpStatus.FOUND).body(blog);
    }

    /*This method should delete the blog taking its id and return the deleted blog */
    @DeleteMapping("/blog/{id}")
    public ResponseEntity<Blog> getBlogAfterDeleting(@PathVariable int id) {
        final var blog = blogService.deleteBlog(id);
        return ResponseEntity.status(HttpStatus.OK).body(blog);
    }

    /*This method should update blog and return the updatedBlog */
    @PutMapping("/blog")
    public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog) {

        if (blog != null) {

            final var blogs = blogService.getBlogById(blog.getBlogId());

            if (blogs == null) {

                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

            }

            blogs.setBlogId(blogs.getBlogId());
            blogs.setBlogTitle(blog.getBlogTitle());
            blogs.setAuthorName(blog.getAuthorName());
            blogs.setBlogContent(blog.getBlogContent());

            final var res = blogService.updateBlog(blogs);
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}