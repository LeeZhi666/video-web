package com.qf.videos.service.impl;

import com.qf.videos.mapper.SpeakerMapper;
import com.qf.videos.pojo.QueryVo;
import com.qf.videos.pojo.Speaker;
import com.qf.videos.service.SpeakerService;
import com.qf.videos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    private SpeakerMapper speakerMapper;
    @Override
    public List<Speaker> selectAll() {
        return speakerMapper.selectAll();
    }

    @Override
    public Page<Speaker> selectSpeakerByQueryVo(QueryVo queryVo) {
        queryVo.setStart((queryVo.getPage() - 1) * queryVo.getSize());

        List<Speaker> speakerList = speakerMapper.selectSpeakerByQueryVo(queryVo);
        Integer total = speakerMapper.selectCountByQueryVo(queryVo);

        Page<Speaker> speakerPage = new Page<>();
        speakerPage.setRows(speakerList);
        speakerPage.setTotal(total);
        speakerPage.setPage(queryVo.getPage());
        speakerPage.setSize(queryVo.getSize());

        return speakerPage;
    }
    @Override
    public Integer selectCountByQueryVo(QueryVo queryVo) {
        return speakerMapper.selectCountByQueryVo(queryVo);
    }
}
