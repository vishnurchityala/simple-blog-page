package com.blog.demoSpringBlogPage.blog;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class blog {

    // Data member for unqiue identity;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Blog datamember for heading;
    @Column(length = 65535)
    private String blogHeading;
    // Blog datameber for blog summary for blogs view;
    @Column(length = 65535)
    private String blogSummary;
    // Blog datamember for blog content;
    @Column(length = 65535)
    private String blogContent;

    // Constrcutors;
    public blog() {
    }

    public blog(Long id, String blogHeading, String blogSummary, String blogContent) {
        this.id = id;
        this.blogHeading = blogHeading;
        this.blogSummary = blogSummary;
        this.blogContent = blogContent;
    }

    // Getters;
    public Long getId() {
        return id;
    }

    public String getIdString() {
        return String.valueOf(id);
    }

    public String getBlogHeading() {
        return blogHeading;
    }
    public String getBlogSummary() {
        return blogSummary;
    }
    public String getBlogContent() {
        return blogContent;
    }

    // Setters;
    public void setId(Long id) {
        this.id = id;
    }
    public void setBlogHeading(String blogHeading) {
        this.blogHeading = blogHeading;
    }
    public void setBlogSummary(String blogSummary) {
        this.blogSummary = blogSummary;
    }
    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }
    
}
