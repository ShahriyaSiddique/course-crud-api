package com.onik.CRUDapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onik.CRUDapi.model.ApiResponse;
import com.onik.CRUDapi.model.Course;
import com.onik.CRUDapi.service.CourseService;

@RestController
public class MyController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/home")
	public String goHome() {
		return "La Ilaha Illallah";
	}

	@GetMapping("/courses")
	public ResponseEntity getCourses() {

		ApiResponse apiResponse = new ApiResponse<>();

		try {

			List<Course> allCourses = courseService.getCourses();
			apiResponse.setData(allCourses);
			apiResponse.setMsg("");
			apiResponse.setStatus(201);

			return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
		} catch (Exception e) {

			apiResponse.setData(null);
			apiResponse.setMsg(e.getMessage());
			apiResponse.setStatus(401);

			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(apiResponse);
		}
	}

	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {

		System.out.println(courseService.getCourseById(Long.parseLong(courseId)));

		return courseService.getCourseById(Long.parseLong(courseId));
	}

	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}

	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}

	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity deleteCourse(@PathVariable String courseId) {

		ApiResponse apiResponse = new ApiResponse<>();

		try {

			Course course = courseService.deleteCourse(Long.parseLong(courseId));
			apiResponse.setData(course);
			apiResponse.setMsg("");
			apiResponse.setStatus(201);

			return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);

		} catch (Exception e) {
			apiResponse.setData(null);
			apiResponse.setMsg(e.getMessage());
			apiResponse.setStatus(401);

			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(apiResponse);
		}
	}
}
