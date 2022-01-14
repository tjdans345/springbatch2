package com.meteor.springbatch2.MultiJobTest2C;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class Schedule2 {

    private final Job job;
    private final JobLauncher jobLauncher;

    @Scheduled(fixedDelay = 30 * 1000L)
    public void executeJob() {
        System.out.println("2번 스케쥴러");
        try {
            jobLauncher.run(
                    job,
                    new JobParametersBuilder()
                            .addString("insertTime2", LocalDateTime.now().toString())
                            .toJobParameters() // job parameter 설정
            );
        } catch (JobExecutionException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
