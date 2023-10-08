package com.udemycourse.springboot.learnspringbootjpa.course;

import com.udemycourse.springboot.learnspringbootjpa.course.jdbc.CourseJDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author bibek
 */
@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJDBCRepository courseRepository;

//    @Autowired
//    private CourseJPARepository courseRepository;

    @Autowired
    private CourseSpringDataJPARepository courseRepository;
    @Override
    public void run(String... args) throws Exception {
//        courseRepository.insert(new Course(1, "Learn SpringBoot Java", "Udemy"));
//        courseRepository.insert(new Course(2, "Learn Python", "Udemy"));
//        courseRepository.insert(new Course(3, "Learn Data Structures Java", "Udemy"));
//        courseRepository.deleteById(2);
        courseRepository.save(new Course(1, "Learn SpringBoot Java", "Udemy"));
        courseRepository.save(new Course(2, "Learn Python", "Udemy"));
        courseRepository.save(new Course(3, "Learn Data Structures Java", "Udemy"));
        courseRepository.deleteById(2l);
//        System.out.println(courseRepository.findById(2));
        System.out.println(courseRepository.findById(1l));
        System.out.println(courseRepository.count());
        System.out.println(courseRepository.findAll());
        System.out.println(courseRepository.findByAuthor("Udemy"));

    }
}
