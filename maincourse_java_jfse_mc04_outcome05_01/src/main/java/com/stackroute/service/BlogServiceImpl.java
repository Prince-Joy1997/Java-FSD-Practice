package com.stackroute.service;

import com.stackroute.domain.Blog;
import com.stackroute.exceptions.BlogAlreadyExistsException;
import com.stackroute.exceptions.BlogNotFoundException;
import com.stackroute.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/* This is ServiceImplementation Class which should implement BlogService Interface and override all the implemented methods.
 * Handle suitable exceptions for all the implemented methods*/

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog saveBlog(Blog blog) {

        if (blogRepository.existsById(blog.getBlogId())){
            throw new BlogAlreadyExistsException();
        }

        return blogRepository.save(blog);
    }

    @Override
    public List<Blog> getAllBlogs() {

        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public Blog getBlogById(int id) {

        Optional<Blog> check = blogRepository.findById(id);

        if (check.isEmpty()){
            throw new BlogNotFoundException();
        }
        return blogRepository.findById(id).get();
    }

    @Override
    public Blog deleteBlog(int id) {
        Optional<Blog> check = blogRepository.findById(id);
        if(check.isEmpty()){
            throw new BlogNotFoundException();
        }
//        final var check = blogRepository.findById(id).get();
//        if(!blogRepository.existsById(check.getBlogId())){
//            throw new BlogNotFoundException();
//        }
        final var blog = blogRepository.findById(id).get();
        blogRepository.deleteById(id);
        return blog;
    }

    @Override
    public Blog updateBlog(Blog blog) {

        if(!blogRepository.existsById(blog.getBlogId())){
            throw new BlogNotFoundException();
        }

        return blogRepository.save(blog);
    }
}

