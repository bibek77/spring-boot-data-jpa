package com.udemycourse.springboot.learnspringbootjpa.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author bibek
 */
public interface PostRepository extends JpaRepository<Post, Integer> {

}
