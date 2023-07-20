package com.stackroute.repository;

/* Add annotation to declare this class as a Repository class.
This interface should extend CRUD Repository
* */

import com.stackroute.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Integer> {
}
