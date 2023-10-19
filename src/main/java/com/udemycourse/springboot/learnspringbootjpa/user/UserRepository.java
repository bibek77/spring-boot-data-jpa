package com.udemycourse.springboot.learnspringbootjpa.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author bibek
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
