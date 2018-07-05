package com.boot.quartz.multiplejobs.service;

import com.boot.quartz.multiplejobs.config.SchedulerJobFactory;
import com.boot.quartz.multiplejobs.config.SchedulerTriggerFactory;
import com.boot.quartz.multiplejobs.job.ExampleJob2;
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
public class SchedulerExampleJob2Service {

    @Autowired
    SchedulerFactoryBean schedulerFactoryBean;

    @Autowired
    SchedulerJobFactory schedulerJobFactory;

    @Autowired
    SchedulerTriggerFactory schedulerTriggerFactory;

    @PostConstruct
    public void setupJobs() throws ParseException, SchedulerException {
        //@Value("${triggers.cron1}") String cron
        scheduleJob(ExampleJob2.class, null, "0/5 * * * * ?", "ExampleJob2", "trigger2");
    }

    public void scheduleJob(Class<? extends QuartzJobBean> object, JobDataMap jMap, String frequency, String jobName, String triggerName)
            throws ParseException, SchedulerException {
        JobDetailFactoryBean jobDetailFactoryBean = schedulerJobFactory.job(object, jMap, jobName);
        CronTriggerFactoryBean cronTriggerFactoryBean = schedulerTriggerFactory.jobTrigger(jobDetailFactoryBean.getObject(), frequency, triggerName);
        schedulerFactoryBean.getScheduler().scheduleJob(jobDetailFactoryBean.getObject(), cronTriggerFactoryBean.getObject());
    }

}
