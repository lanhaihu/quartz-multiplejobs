package com.boot.quartz.multiplejobs.recordsrequest;

import com.boot.quartz.multiplejobs.entity.baseEntity.RecordsToDbEntity;

/**
 * Created by zou on 2018/7/10.
 */
public interface RecordsRequest {
    public int saveRecordsToDb(String tableName, RecordsToDbEntity recordsToDbEntity);

}
