package com.onik.CRUDapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onik.CRUDapi.model.Course;

public interface CourseDao extends JpaRepository<Course, Long> {

}
