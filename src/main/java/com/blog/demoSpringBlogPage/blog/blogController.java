package com.blog.demoSpringBlogPage.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class blogController {
    
    @Autowired
    blogService blogservice;

    // Controller Mapping to map unknown urls;
    @RequestMapping(method = RequestMethod.GET, value = "*")
    public String pageNotFound()
    {
        return "pagenotfound";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String redirectToBlogs() {
        return "redirect:/blogs";
    }

    // Controller Mapping to list down all blog posts;
    @RequestMapping(method = RequestMethod.GET , value = "/blogs")
    public ModelAndView getAllBlogs()
    {
        ModelAndView modelAndView = new ModelAndView("blogs");
        modelAndView.addObject("blogs", blogservice.getAllBlogs());
        return modelAndView;
    }

    // Controller Mapping to bind add form to the add blog page;
    @RequestMapping(method = RequestMethod.GET, value = "/blog/add")
    public ModelAndView getAddBlogForm( )
    {
        ModelAndView modelAndView = new ModelAndView("addBlog");
        blog newBlog = new blog();
        modelAndView.addObject("newBlog", newBlog);
        return modelAndView;
    }

    // Controller Mapping to add blog data;
    @RequestMapping(method = RequestMethod.POST, value = "/blog/add")
    public ModelAndView addBlog(@ModelAttribute("newBlog") blog newBlog)
    {
        ModelAndView modelAndView = new ModelAndView("addBlogSuccess");
        modelAndView.addObject("newBlog", newBlog);
        blogservice.addBlog(newBlog);
        return modelAndView;
    }

    // Controller Mapping to view a particular blog;
    @RequestMapping(method = RequestMethod.GET , value = "/blog/{id}")
    public ModelAndView getBlog(@PathVariable String id)
    {
        blog mblog = blogservice.getBlogById(Long.valueOf(id));
        ModelAndView modelAndView =  new ModelAndView("blog");
        modelAndView.addObject("blog", mblog);
        return modelAndView;
    }

    // Controller Mapping to delete a blog;
    @RequestMapping(method = RequestMethod.GET , value = "/blog/delete/{id}")
    public String deleteBlog(@PathVariable String id)
    {
        blogservice.deleteBlog(Long.valueOf(id));
        return "redirect:/blogs";
    }

    // Controller Mapping to edit a blog;
    @RequestMapping(method = RequestMethod.GET , value = "/blog/edit/{id}")
    public ModelAndView getEditBlog(@PathVariable String id, blog editedblog)
    {
        ModelAndView modelAndView = new ModelAndView("editBlog");
        modelAndView.addObject("blog", editedblog);
        return modelAndView;
    }

    // Controller Mapping to edit a blog;
    @RequestMapping(method = RequestMethod.POST , value = "/blog/edit/{id}")
    public ModelAndView editBlog(@PathVariable String id, @ModelAttribute("blog") blog editedblog)
    {
        ModelAndView modelAndView = new ModelAndView("editBlogSuccess");
        blogservice.editBlog(editedblog);
        return modelAndView;
    }    

}
