package com.restapi.springrest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.springrest.entity.Course;
import com.restapi.springrest.service.CourseService;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home() {
        return "Welcome to Courses application";
    }

    // get the courses
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable("courseId") String courseId){
        return this.courseService.getCoursesById(Long.parseLong(courseId));

    }

    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    @PutMapping("/update/{id}")
    public Course updatCourse(@RequestBody Course course, @PathVariable("id") String id){
       return this.courseService.updatCourse(course,Long.parseLong(id));
    }

}
