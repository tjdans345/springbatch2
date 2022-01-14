package com.meteor.springbatch2.MultiJobTest2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Configuration("test1")
public class JobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Qualifier("test1")
    public Job jobTest() {
        return jobBuilderFactory.get("jobTest1")
                .start(stepTest())
                .build();
    }

    @Bean
    public Step stepTest() {
        return stepBuilderFactory.get("stepTest1")
                .tasklet((contribution, chunkContext) -> {
                    log.info(">>>>>>>> stepTest 1 <<<<<<<<<<");
                    log.info("1번째");
                    return RepeatStatus.FINISHED;
                }).build();
    }

}
