package com.qf.videos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.videos.pojo.QueryVo;
import com.qf.videos.pojo.Speaker;
import com.qf.videos.pojo.Video;
import com.qf.videos.service.SpeakerService;
import com.qf.videos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("speaker")
public class SpeakerController {
    @Autowired
    private SpeakerService speakerService;
    @RequestMapping("list")
    public Map showSpeakerList(Integer page,Integer limit){

        PageHelper.startPage(page,limit);

        List<Speaker> speakers = speakerService.selectAll();
        PageInfo<Speaker> pageInfo = new PageInfo<>(speakers);

        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());//总记录数
        map.put("data",pageInfo.getList());//分页数据

        return map;

    }
}
