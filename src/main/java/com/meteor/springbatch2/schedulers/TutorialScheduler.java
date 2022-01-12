package com.meteor.springbatch2.schedulers;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class TutorialScheduler {

    private final Job job;
    private final JobLauncher jobLauncher;

    @Scheduled(fixedDelay = 5 * 1000L)
    public void executeJob() {
        try {
            jobLauncher.run(
                    job,
                    new JobParametersBuilder()
                            .addString("dateTime", LocalDateTime.now().toString())
                            .toJobParameters() // job parameter 설정
            );
        } catch (JobExecutionException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
