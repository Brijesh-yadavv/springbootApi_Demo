package com.restapi.springrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.restapi.springrest.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

    List<Course> list;
    
    public CourseServiceImpl() {
        list=new ArrayList<>();
        list.add(new Course(12,"java core","this is java course contains basics of java"));
                list.add(new Course(13,"springboot course","this is java course contains basics of springboot course"));



    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCoursesById(long id) {
       for (Course course : list) {
        if(course.getId()==id){
            return course;
        }
       }
       return null;
    }

    @Override
    public Course addCourse(Course c) {
        list.add(c);
        return c;
    }

    @Override
    public Course updatCourse(Course course,long id) {

        
        for (Course course2 : list) {
            if(course2.getId()==id){
                course2.setTitle(course.getTitle());
                course2.setDesc(course.getDesc());
                course2.setId(course.getId());

            }
        }
        return course;
    }

}
