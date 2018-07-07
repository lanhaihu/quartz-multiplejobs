package com.boot.quartz.multiplejobs.db.entity;

import javax.persistence.GeneratedValue;

/**
 * Created by zhaos on 2018/7/6.
 */
public class TestEntity extends BaseEntity {
    private int costsEstimateId;
    private int reckonUnitId;

    public int getCostsEstimateId() {
        return costsEstimateId;
    }

    public void setCostsEstimateId(int costsEstimateId) {
        this.costsEstimateId = costsEstimateId;
    }

    public int getReckonUnitId() {
        return reckonUnitId;
    }

    public void setReckonUnitId(int reckonUnitId) {
        this.reckonUnitId = reckonUnitId;
    }




}
