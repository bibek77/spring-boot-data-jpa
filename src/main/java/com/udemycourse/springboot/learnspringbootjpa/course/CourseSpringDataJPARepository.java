package com.udemycourse.springboot.learnspringbootjpa.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author bibek
 */
public interface CourseSpringDataJPARepository  extends JpaRepository<Course, Long> {

    List<Course> findByAuthor(String author);

}
