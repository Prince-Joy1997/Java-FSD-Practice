package com.stackroute.service;


import com.stackroute.domain.Blog;
import com.stackroute.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* Add annotation to declare this class as Service class.
 * Also it should implement BlogService Interface and override all the implemented methods.*/
@Service
public class BlogServiceImpl implements BlogService {

    private BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public List<Blog> getAllBlogs() {

        return blogRepository.findAll();
    }

    @Override
    public Blog getBlogById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public Blog deleteBlog(int id) {
        Optional<Blog> res = blogRepository.findById(id);
        if (res.isEmpty()){
            return null;
        }
        blogRepository.deleteById(id);
        Blog blog = blogRepository.findById(id).get();
        return blog;
    }

    @Override
    public Blog updateBlog(Blog blog) {
        Optional<Blog> blog1 = blogRepository.findById(blog.getBlogId());
        if (blog1.isPresent()) {
            blogRepository.findById(blog.getBlogId());
            Blog res = blogRepository.save(blog);
            return res;
        }
        return null;
    }
}
