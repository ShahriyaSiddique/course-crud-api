package com.onik.CRUDapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onik.CRUDapi.dao.CourseDao;
import com.onik.CRUDapi.model.Course;

@Service
public class CourseServiceImpl implements CourseService {

//	List<Course> list;

	@Autowired
	private CourseDao courseDao;

	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(1, "one", "des"));
//		list.add(new Course(2, "two", "tdes"));
	}

	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
	}

	@Override
	public Course getCourseById(Long id) {

		return courseDao.findById(id).get(); // getOne() gives error
	}

	@Override
	public Course addCourse(Course course) {
//		list.add(course);

		courseDao.save(course);

		return course;
	}

	@Override
	public Course deleteCourse(long id) {	
		Course course = courseDao.findById(id).get();
		courseDao.deleteById(id);		
		return course;
	}

}
