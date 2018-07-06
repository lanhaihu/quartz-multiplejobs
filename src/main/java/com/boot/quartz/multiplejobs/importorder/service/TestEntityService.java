package com.boot.quartz.multiplejobs.importorder.service;

import com.boot.quartz.multiplejobs.db.entity.TestEntity;
import com.boot.quartz.multiplejobs.db.mapper.TestEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhaos on 2018/7/6.
 */
@Service
public class TestEntityService {

    @Autowired
    private TestEntityMapper testEntityMapper;

    public List<TestEntity> getEntitys(String id){
        return testEntityMapper.findById(id);
    }
}
