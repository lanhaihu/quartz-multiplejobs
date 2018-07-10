package com.boot.util;

import com.boot.quartz.multiplejobs.entity.baseEntity.RecordsToDbEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zou on 2018/7/10.
 */
@Slf4j
public class LogerRequestToDB {

    public int loggerRequestToDb(String tableName, List<RecordsToDbEntity> recordsList){
        int records=0;
        if(recordsList!=null&&recordsList.size()>0){
            for(RecordsToDbEntity recordsToDbEntity :recordsList){
            //todo 保存至数据库 ,如果保存成功,
                try{
                    //todo save 构建工厂方法，通过传不通的tableName，映射不同的保存字段
                }catch (Exception e){
                    log.error("保存记录失败，原因为"+e);
                    log.error("未保存的记录为,请求为:"+recordsToDbEntity.toString());
                }
            }
        }
        return records;
    }
}
