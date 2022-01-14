package com.meteor.springbatch2.MultiJobTest2;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class Schedule {

    private final Job job;
    private final JobLauncher jobLauncher;

    @Scheduled(fixedDelay = 5 * 1000L)
    public void executeJob() {
        System.out.println(job.getName());
        System.out.println("1번 스케쥴러");
        try {
            jobLauncher.run(
                    job,
                    new JobParametersBuilder()
                            .addString("insertTime", LocalDateTime.now().toString())
                            .toJobParameters() // job parameter 설정
            );
        } catch (JobExecutionException e) {
            System.out.println("1번째");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


}
