package com.boot.quartz.multiplejobs.importorder.service;

import com.boot.quartz.multiplejobs.db.entity.CargoListEntity;
import com.boot.quartz.multiplejobs.db.mapper.ImportOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaos on 2018/7/7.
 */
public class ImportOrderService {
    @Autowired
    private ImportOrderMapper importOrderMapper;

    public void startImportCargoList(){
        //获取随货同行数据
        //处理数据成可转换为XML的实体
        //提交数据
        //更新状态
    }

    private List<CargoListEntity> getCargoList(){
        List<CargoListEntity> entitys = new ArrayList<CargoListEntity>();
        entitys = importOrderMapper.findByOutputStatus("1");
        return entitys;
    }

}
