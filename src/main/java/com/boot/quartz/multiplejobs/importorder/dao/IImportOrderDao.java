package com.boot.quartz.multiplejobs.importorder.dao;


import com.boot.quartz.multiplejobs.bean.dr_estimate_costs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhaos on 2018/7/5.
 */
public interface IImportOrderDao  extends JpaRepository<dr_estimate_costs, Integer> {

    @Query(value = "select * from DR_ESTIMATE_COSTS where costs_estimate_id != ?1", nativeQuery = true)
    List<dr_estimate_costs> findOrders(int costs_estimate_id);

    @Query(value = "select * from DR_ESTIMATE_COSTS where costs_estimate_id != ?1", nativeQuery = true)
    List findOrdersMap(int costs_estimate_id);


    @Query(value = "update dr_estimate_costs set RECKON_UNIT_ID =?1 where COSTS_ESTIMATE_ID =?2 ",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    @Transactional
    public Integer updateByIds(int RECKON_UNIT_ID,int COSTS_ESTIMATE_ID);
}
