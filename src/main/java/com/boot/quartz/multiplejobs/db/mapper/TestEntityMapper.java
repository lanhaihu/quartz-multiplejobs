package com.boot.quartz.multiplejobs.db.mapper;

import com.boot.quartz.multiplejobs.db.entity.TestEntity;

import java.util.List;

/**
 * Created by zhaos on 2018/7/6.
 */
public interface TestEntityMapper {
    List<TestEntity> findById(String id);
}
