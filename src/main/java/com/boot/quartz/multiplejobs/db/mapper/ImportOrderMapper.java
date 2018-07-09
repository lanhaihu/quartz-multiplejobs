package com.boot.quartz.multiplejobs.db.mapper;

import com.boot.quartz.multiplejobs.db.entity.CargoListEntity;
import com.boot.quartz.multiplejobs.db.entity.DeliverListEntiy;
import com.boot.quartz.multiplejobs.db.entity.TestEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaos on 2018/7/7.
 */
public interface ImportOrderMapper {
    List<CargoListEntity> findByOutputStatus(String status);

    int updateCargoListByIds(ArrayList<String> Ids);

    int updateCargoListBByCarGoIds(ArrayList<String> Ids);

    List<DeliverListEntiy>findDelistByOutputStatus(String status);
}
