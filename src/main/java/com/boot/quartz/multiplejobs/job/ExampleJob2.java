package com.boot.quartz.multiplejobs.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

@Service
public class ExampleJob2 extends QuartzJobBean {


    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("EXECUTE JOB 2");
    }
}
