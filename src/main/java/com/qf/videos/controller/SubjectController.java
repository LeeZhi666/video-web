package com.qf.videos.controller;

import com.qf.videos.pojo.Subject;
import com.qf.videos.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @RequestMapping("selectAll")
    public ModelAndView selectAll(){
//        ServletContext servletContext = request.getSession().getServletContext();

        List<Subject> subjects = subjectService.selectAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("subjectList",subjects);
//        servletContext.setAttribute("subjectList",subjects);
        modelAndView.setViewName("/WEB-INF/jsp/before/index.jsp");
        return modelAndView;
//        return new ModelAndView("/WEB-INF/jsp/before/index.jsp");
    }
}
