package com.felipeam10.send_book_email_spring_batch.config;

import com.felipeam10.send_book_email_spring_batch.job.SendBookLoanNotificationScheduleJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail quartzJobDetail() {
        return JobBuilder.newJob(SendBookLoanNotificationScheduleJob.class).storeDurably().build();
    }

    @Bean
    public Trigger jobTrigger() {
//                   <second> <minute> <hour> <day-of-month> <month> <day-of-week> <year (optional)>
        String exp = "0 03 01 * * ?";
        return TriggerBuilder
                .newTrigger()
                .forJob(quartzJobDetail())
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule(exp))
                .build();
    }
}
