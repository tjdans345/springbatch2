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
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.support.ListItemReader;
//import org.springframework.batch.jsr.item.ItemProcessorAdapter;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import java.lang.reflect.Member;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class MultiOtherJob {
//
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//    private final Job job;
//    private final JobLauncher jobLauncher;
//
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
//    public Job otherJob() {
//        return jobBuilderFactory.get("otherJob")
//                .start(otherStep())
//                .build();
//    }
//
//    @Bean Job otherJob2() {
//        return this.jobBuilderFactory.get("otherJob2").incrementer(new RunIdIncrementer())
//                .start(otherStep()).build();
//    }
//
////    @Bean
////    public Step otherStep() {
////        return stepBuilderFactory.get("otherStep")
////                .<Object, Object> chunk(100)
////                .tasklet((contribution, chunkContext) -> {
////                    log.info(">>>>>>>> other job started");
////                    return RepeatStatus.FINISHED;
////                }).build();
////    }
//
//    @Bean
//    public Step otherStep() {
//        return stepBuilderFactory.get("otherStep")
//                .<Object, Object> chunk(100)
//                .reader(testReader())
//                .writer(testWriter())
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public ListItemReader<?> testReader() {
//        List<Object> list = new ArrayList<>();
//        return new ListItemReader<>(list);
//    }
//
////    public ItemProcessor<?, ?> testProcessor() {
////        return item ->
////    }
//
//    public ItemWriter<Object> testWriter() {
//        return items -> items.get(items.size());
//    }
//
//}
