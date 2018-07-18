package com.boot.quartz.multiplejobs.service;

import com.boot.quartz.multiplejobs.config.SchedulerJobFactory;
import com.boot.quartz.multiplejobs.config.SchedulerTriggerFactory;
import com.boot.quartz.multiplejobs.job.ImportOrderJob;
import com.boot.util.ConstantInfoUtil;
import org.quartz.JobDataMap;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.ParseException;

@Service
public class SchedulerImportOrderService {

    @Value("${triggers.importOrder}")
    String cron;

    @Value("${request.user.name}")
    String userName;

    @Value("${request.user.password}")
    String userPassword;

    @Value("${request.url}")
    String requestUrl;

    @Value("${request.version}")
    String requestVersion;

    @Value("${importOrder.sendMaxCount}")
    int sendMaxCount;

    @Autowired
    SchedulerFactoryBean schedulerFactoryBean;

    @Autowired
    SchedulerJobFactory schedulerJobFactory;

    @Autowired
    SchedulerTriggerFactory schedulerTriggerFactory;

    @PostConstruct
    public void setupJobs() throws ParseException, SchedulerException {

        ConstantInfoUtil.setREQUESTURL(requestUrl);
        ConstantInfoUtil.setREQUESTVERSION(requestVersion);
        ConstantInfoUtil.setUSERNAME(userName);
        ConstantInfoUtil.setUSERPASSWORD(userPassword);
        ConstantInfoUtil.setSendMaxCount(sendMaxCount);

        scheduleJob(ImportOrderJob.class, null,cron , "ImportOrderJob", "ImportOrderJobTrigger");
        //scheduleJob(ExampleJob1.class, null,cron , "ExampleJob1", "trigger1");
    }

    public void scheduleJob(Class<? extends QuartzJobBean> object, JobDataMap jMap, String frequency, String jobName, String triggerName)
            throws ParseException, SchedulerException {
        JobDetailFactoryBean jobDetailFactoryBean = schedulerJobFactory.job(object, jMap, jobName);
        CronTriggerFactoryBean cronTriggerFactoryBean = schedulerTriggerFactory.jobTrigger(jobDetailFactoryBean.getObject(), frequency, triggerName);
        schedulerFactoryBean.getScheduler().scheduleJob(jobDetailFactoryBean.getObject(), cronTriggerFactoryBean.getObject());
    }

}
