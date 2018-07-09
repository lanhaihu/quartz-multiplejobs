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
        if(recordsList!=null&&recordsList.size()>0){
            for(RecordsToDbEntity recordsToDbEntity :recordsList){

            }
        }
        return 1;
    }
}
