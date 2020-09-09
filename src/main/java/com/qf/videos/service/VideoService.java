package com.qf.videos.service;

import com.qf.videos.pojo.QueryVo;
import com.qf.videos.pojo.Video;
import com.qf.videos.utils.Page;

import java.util.List;

public interface VideoService {
    Page<Video> selectVideoByQueryVo(QueryVo queryVo);
    void deleteById(String id);
    Video selectVideoById(String id);
    void updateVideo(Video video);
    void insertVideo(Video video);
    List<Video> selectAll();
}
