package com.meteor.springbatch2.MultiTest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class MultiJobTest {

    private final JobLauncher jobLauncher;

    @Qualifier("job1-file-A")
    private final Job job1;

    @Qualifier("job1-file-B")
    private final Job job2;

    @Scheduled(fixedDelay = 30 * 1000L)
    public void run1() {
        Map<String, JobParameter> confMap = new HashMap<>();
        confMap.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(confMap);
        try {
            jobLauncher.run(job1, jobParameters);
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
    }

    @Scheduled(fixedDelay = 50 * 1000L)
    public void run2() {
        Map<String, JobParameter> confMap = new HashMap<>();
        confMap.put("time2", new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(confMap);
        try {
            jobLauncher.run(job2, jobParameters);
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
    }


}
