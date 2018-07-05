package com.boot.quartz.multiplejobs.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Created by zhaos on 2018/7/5.
 */
@Entity
@Table(name="dr_estimate_costs")
public class dr_estimate_costs {
    private int costs_estimate_id;
    private int reckon_unit_id;

    @Id
    @GeneratedValue
    public int getReckon_unit_id() {
        return reckon_unit_id;
    }

    public void setReckon_unit_id(int reckon_unit_id) {
        this.reckon_unit_id = reckon_unit_id;
    }

    public int getCosts_estimate_id() {
        return costs_estimate_id;
    }

    public void setCosts_estimate_id(int costs_estimate_id) {
        this.costs_estimate_id = costs_estimate_id;
    }

}
