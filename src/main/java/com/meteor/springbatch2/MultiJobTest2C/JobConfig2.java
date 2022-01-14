package com.meteor.springbatch2.MultiJobTest2C;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@RequiredArgsConstructor
@Configuration("test2")
public class JobConfig2 {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job jobTest2() {
        return jobBuilderFactory.get("jobTest2")
                .start(stepTest2())
                .next(stepTest3())
                .build();
    }

    @Bean
    public Step stepTest2() {
        return stepBuilderFactory.get("stepTest2")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("");
                    log.info(">>>>>>>> stepTest 2 <<<<<<<<<<");
                    log.info("2번째");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Step stepTest3() {
        return stepBuilderFactory.get("stepTest3")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("");
                    log.info(">>>>>>>> stepTest 3 <<<<<<<<<<");
                    log.info("3번째");
                    return RepeatStatus.FINISHED;
                }).build();
    }



}
