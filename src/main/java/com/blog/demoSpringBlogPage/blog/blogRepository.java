package com.blog.demoSpringBlogPage.blog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface blogRepository extends CrudRepository<blog, Long>  {

}
