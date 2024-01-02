package com.restapi.springrest.service;

import java.util.List;

import com.restapi.springrest.entity.Course;

public interface CourseService {

    public List<Course> getCourses();

    public Course getCoursesById(long id);

    public Course addCourse(Course c);

    public Course updatCourse(Course course,long id);

}
