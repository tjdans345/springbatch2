//package com.meteor.springbatch2.jobs;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobExecutionException;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import java.time.LocalDateTime;
//
//@Slf4j
//@RequiredArgsConstructor
//@Configuration
//public class MultiSimpleJob {
//
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;

//    private final Job job;
//    private final JobLauncher jobLauncher;

//    @Scheduled(fixedDelay = 30 * 1000L)
//    public void executeJob() {
//        try {
//            jobLauncher.run(
//                    job,
//                    new JobParametersBuilder()
//                            .addString("insertTime", LocalDateTime.now().toString())
//                            .toJobParameters() // job parameter 설정
//            );
//        } catch (JobExecutionException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }

//
//    @Bean
//    public Job simpleJob() {
//        return jobBuilderFactory.get("simpleJob")
//                .start(simpleStep())
//                .build();
//    }
////
////    @Bean
////    public Job simpleJob() {
////        return jobBuilderFactory.get("simpleJob")
////                .start(simpleStep())
////                .build();
////    }
////
////    @Bean
////    public Step simpleStep() {
////        return stepBuilderFactory.get("simpleStep")
////                .tasklet(((contribution, chunkContext) -> {
////                    log.info(">>>>>>>>>>>>>>>>> simple job started >>>>>>>>>>>");
////                    return RepeatStatus.FINISHED;
////                })).build();
////    }
////
////}
//    @Bean
//    public Step simpleStep() {
//        return stepBuilderFactory.get("simpleStep")
//                .tasklet(((contribution, chunkContext) -> {
//                    log.info(">>>>>>>>>>>>>>>>> simple job started >>>>>>>>>>>");
//                    return RepeatStatus.FINISHED;
//                })).build();
//    }
//
//}
