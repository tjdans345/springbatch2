//package com.meteor.springbatch2.jobs;
//
//import com.meteor.springbatch2.tasklet.TutorialTasklet;
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@RequiredArgsConstructor
//public class TutorialJob2 {
//
//    private final JobBuilderFactory jobBuilderFactory; // Job 빌더 생성 Job을 쉽게 만들 수 있도록 도와 주는 클래
//    private final StepBuilderFactory stepBuilderFactory; // step 빌더 생성
//
//    // JobBuilderFactory를 통해서 tutorialJob을 생성
//    @Bean
//    public Job tutorialJob3() {
//        return jobBuilderFactory.get("tutorialJob3") // Job 이름을 tutorialJob으로 설정
//                .start(tutorialStep()) // Job에 처음으로 시작할 스텝을 등록
//                .build();
//    }
//
//    // StepBuilderFactory를 통해서 tutorialStep을 생성
//    @Bean
//    public Step tutorialStep() {
//        return stepBuilderFactory.get("tutorialStep")
//                .tasklet(new TutorialTasklet()) // Tasklet 설정
//                .build();
//    }
//
//
//
//}
