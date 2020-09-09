package com.qf.videos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.videos.mapper.CourseMapper;
import com.qf.videos.pojo.Course;
import com.qf.videos.pojo.Subject;
import com.qf.videos.pojo.Video;
import com.qf.videos.service.CourseService;
import com.qf.videos.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private SubjectService subjectService;
    @RequestMapping("list")
    public Map list(Integer page,Integer limit){
        PageHelper.startPage(page,limit);

        List<Course> courses = courseService.selectAll();

        PageInfo<Course> pageInfo = new PageInfo<>(courses);

//        System.out.println(pageInfo.getList());

        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());//总记录数
        map.put("data",pageInfo.getList());//分页数据
        return map;
    }
    @RequestMapping("course/{subjectId}")
    public ModelAndView course(@PathVariable String subjectId) {
//        System.out.println(subjectId);
        Subject subject = subjectService.selectSubjectById(subjectId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("subject", subject);
        modelAndView.setViewName("/WEB-INF/jsp/before/course.jsp");
//        System.out.println(subjectId);
        return modelAndView;
    }
}
