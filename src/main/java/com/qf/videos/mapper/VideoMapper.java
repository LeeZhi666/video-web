package com.qf.videos.mapper;

import com.qf.videos.pojo.QueryVo;
import com.qf.videos.pojo.Video;
import com.qf.videos.utils.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoMapper {

    List<Video> selectVideoByQueryVo(QueryVo queryVo);
    Integer selectCountByQueryVo(QueryVo queryVo);
    void deleteById(String id);
    Video selectVideoById(String id);
    void updateVideo(Video video);
    void insertVideo(Video video);
    List<Video> selectAll();
}
