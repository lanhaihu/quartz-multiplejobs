package com.boot.quartz.multiplejobs.importorder.service;


import com.boot.quartz.multiplejobs.bean.dr_estimate_costs;

import java.util.List;
/**
 * Created by zhaos on 2018/7/5.
 */
public interface IImportOrderService {
    public List queryEmpAll();
    public List<dr_estimate_costs> queryEmpById(int id);

    public void updateByIds(int id,int value);
}
