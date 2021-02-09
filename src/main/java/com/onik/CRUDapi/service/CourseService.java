package com.onik.CRUDapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onik.CRUDapi.model.Course;

public interface CourseService {

	public List<Course> getCourses();

	public Course getCourseById(Long id);

	public Course addCourse(Course course);

	public Course deleteCourse(long parseLong);
}
