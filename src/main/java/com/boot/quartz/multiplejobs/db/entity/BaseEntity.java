package com.boot.quartz.multiplejobs.db.entity;

/**
 * Created by zhaos on 2018/7/6.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;

public class BaseEntity {

    private String id;

    @JsonIgnore
    private Map<String, String> sqlMap = new HashMap<String,String>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, String> getSqlMap() {
        return sqlMap;
    }

    public void setSqlMap(Map<String, String> sqlMap) {
        this.sqlMap = sqlMap;
    }
}
