package com.blog.demoSpringBlogPage.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class blogService {
    
    @Autowired
    blogRepository blogrepository;


    // Method to add new blog data;
    @Transactional
    public void addBlog(blog mblog)
    {
        blogrepository.save(mblog);
    }

    // Method to fetch all blogs data;
    @Transactional
    public List<blog> getAllBlogs()
    {   
        return (List<blog>) blogrepository.findAll();
    }

    //Method to fetch blog data using id;
    @Transactional
    public blog getBlogById(Long id)
    {
        return blogrepository.findById(id).get();
    }

    // Method to delete a blog data using id;
    @Transactional
    public void deleteBlog(Long id)
    {
        blogrepository.deleteById(id);
    }

    // Method to edit a blod data using Blog
    @Transactional
    public void editBlog(blog editblog)
    {
        blogrepository.save(editblog);
    }

}
