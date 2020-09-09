package com.qf.videos.service.impl;

import com.qf.videos.mapper.VideoMapper;
import com.qf.videos.pojo.QueryVo;
import com.qf.videos.pojo.Video;
import com.qf.videos.service.VideoService;
import com.qf.videos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public Page<Video> selectVideoByQueryVo(QueryVo queryVo) {
        queryVo.setStart((queryVo.getPage() - 1) * queryVo.getSize());

        List<Video> videoList = videoMapper.selectVideoByQueryVo(queryVo);
        Integer total = videoMapper.selectCountByQueryVo(queryVo);

        Page<Video> videoPage = new Page<>();
        videoPage.setRows(videoList);
        videoPage.setTotal(total);
        videoPage.setPage(queryVo.getPage());
        videoPage.setSize(queryVo.getSize());

        return videoPage;
    }

    @Override
    public void deleteById(String id) {
        videoMapper.deleteById(id);
    }


//    @Override
//    public void deleteById(String id) {
//        videoMapper.deleteById(id);
//    }
//
    @Override
    public Video selectVideoById(String id) {
        return videoMapper.selectVideoById(id);
    }
//
    @Override
    public void updateVideo(Video video) {
        videoMapper.updateVideo(video);
    }

    @Override
    public void insertVideo(Video video) {
       videoMapper.insertVideo(video);
    }

    @Override
    public List<Video> selectAll() {
        return videoMapper.selectAll();
    }
}


