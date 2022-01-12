//package com.meteor.springbatch2.MultiTest;//package com.meteor.springbatch2.jobs;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//@Slf4j
//@RequiredArgsConstructor
//@Configuration
//public class MultiSimpleJob2 {
//
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//
//
//    @Bean
//    @Qualifier("job1-file-B")
//    public Job simpleJob2() {
//        return jobBuilderFactory.get("simpleJob2")
//                .start(simpleStep2())
//                .build();
//    }
//
//    @Bean
//    public Step simpleStep2() {
//        return stepBuilderFactory.get("simpleStep2")
//                .tasklet(((contribution, chunkContext) -> {
//                    log.info(">>>>>>>>>>>>>>>>> 킹킹 job started >>>>>>>>>>>");
//                    return RepeatStatus.FINISHED;
//                })).build();
//    }
//
//
//}
