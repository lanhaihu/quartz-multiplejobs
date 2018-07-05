package com.boot.quartz.multiplejobs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class JobScheduleConfig {

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setOverwriteExistingJobs(true);
        factory.setAutoStartup(true);
        factory.setQuartzProperties(quartzProperties());
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        factory.setJobFactory(jobFactory);
        return factory;
    }

    @Bean
    public Properties quartzProperties() throws IOException {
        Properties quartzProperties = new Properties();
        quartzProperties.setProperty("org.quartz.scheduler.instanceName","multiplejobs");
        quartzProperties.setProperty("org.quartz.scheduler.instanceId","AUTO");
        quartzProperties.setProperty("org.quartz.scheduler.skipUpdateCheck","true");
        quartzProperties.setProperty("org.quartz.threadPool.class","org.quartz.simpl.SimpleThreadPool");
        quartzProperties.setProperty("org.quartz.threadPool.threadCount","1");
        quartzProperties.setProperty("org.quartz.jobStore.class","org.quartz.simpl.RAMJobStore ");

        return quartzProperties;
    }
}
