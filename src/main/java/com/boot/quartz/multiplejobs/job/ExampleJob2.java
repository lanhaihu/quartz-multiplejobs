package com.boot.quartz.multiplejobs.job;

import com.boot.quartz.multiplejobs.db.entity.TestEntity;
import com.boot.quartz.multiplejobs.importorder.service.TestEntityService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExampleJob2 extends QuartzJobBean {

    @Autowired
    private TestEntityService testEntityService;

    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("EXECUTE JOB 2");
        /*List<TestEntity> entitys = new ArrayList<TestEntity>();
        entitys = testEntityService.getEntitys("1");
        for(TestEntity entity : entitys){
            System.out.println(entity.getReckonUnitId());
            System.out.println(entity.getCostsEstimateId());
        }*/
    }
}
