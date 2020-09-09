package com.qf.videos.service;

import com.qf.videos.pojo.Course;

import java.util.List;

public interface CourseService {
    List<Course> selectAll();
    Course selectCourseById(String id);
}
