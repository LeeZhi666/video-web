package com.qf.videos.mapper;

import com.qf.videos.pojo.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    List<Course> selectAll();
    Course selectCourseById(String id);
}
