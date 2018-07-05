package com.boot.quartz.multiplejobs.importorder.service.Impl;

import java.util.List;

import com.boot.quartz.multiplejobs.bean.dr_estimate_costs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boot.quartz.multiplejobs.importorder.service.IImportOrderService;
import com.boot.quartz.multiplejobs.importorder.dao.IImportOrderDao;
/**
 * Created by zhaos on 2018/7/5.
 */

@Service
public class ImportOrderServiceImpl  implements  IImportOrderService{
    @Autowired
    private IImportOrderDao importOrderDao;

    @Override
    public List queryEmpAll() {
        // TODO Auto-generated method stub
        return importOrderDao.findAll();
    }

    @Override
    public List<dr_estimate_costs> queryEmpById(int id){
        return importOrderDao.findOrders(id);
    }

    @Override
    public void updateByIds(int id,int value){
        importOrderDao.updateByIds(id,value);
    }
}
