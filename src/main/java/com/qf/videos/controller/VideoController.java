package com.qf.videos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.videos.pojo.Course;
import com.qf.videos.pojo.QueryVo;
import com.qf.videos.pojo.Speaker;
import com.qf.videos.pojo.Video;
import com.qf.videos.service.CourseService;
import com.qf.videos.service.SpeakerService;
import com.qf.videos.service.VideoService;
import com.qf.videos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SpeakerService speakerService;

    @RequestMapping("list")
    public Map list(Integer page,Integer limit) {

        PageHelper.startPage(page,limit);

            List<Video> videos = videoService.selectAll();
            PageInfo<Video> pageInfo = new PageInfo<>(videos);

//               for (Video video : videos) {
//            System.out.println(video);
//        }

            HashMap<String, Object> map = new HashMap<>();
            map.put("code",0);
            map.put("msg","");
            map.put("count",pageInfo.getTotal());//总记录数
            map.put("data",pageInfo.getList());//分页数据

//        List<Video> list = pageInfo.getList();
//        for (Video video : list) {
//            System.out.println(video);
//        }

        return map;

    }

    @RequestMapping("selectVideos")
    public List<Video> selectVideos(){
        return videoService.selectAll();
    }

    @RequestMapping("videoDel")
    public void videoDel(String id) {
        videoService.deleteById(id);
    }

    @RequestMapping("edit")
    public ModelAndView edit(String id) {
        ModelAndView modelAndView = new ModelAndView();
        Video video = videoService.selectVideoById(id);
        modelAndView.addObject("video", video);
        modelAndView.setViewName("/jsp/behind/addVideo.jsp");
        List<Speaker> speakers = speakerService.selectAll();
        List<Course> courses = courseService.selectAll();
        modelAndView.addObject("courseList", courses);
        modelAndView.addObject("speakerList", speakers);
        return modelAndView;
    }

    @RequestMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(Video video) {
        if (video.getId() != null) {
            videoService.updateVideo(video);
        }
        else{
            videoService.insertVideo(video);
        }
        return new ModelAndView("list");
    }
    @RequestMapping("updateVideo")
    public void updateVideo(Video video){
        videoService.updateVideo(video);
    }
    @RequestMapping("deleteByIds")
    public void deleteByIds(Integer[] ids){
        for (Integer id : ids) {
            String s = String.valueOf(id);
            videoService.deleteById(s);
        }

    }
    @RequestMapping("insertVideo")
    public void insertVideo(Video video){
        videoService.insertVideo(video);
    }

    @RequestMapping("showVideo")
    public ModelAndView showVideo(String videoId,String subjectName){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("subjectName",subjectName);
        Video video = videoService.selectVideoById(videoId);
        modelAndView.addObject("video",video);
        Course course = courseService.selectCourseById(video.getCourseId().toString());
        modelAndView.addObject(course);
        modelAndView.setViewName("/WEB-INF/jsp/before/section.jsp");
        return modelAndView;
    }

}
