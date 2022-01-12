//package com.meteor.springbatch2.tasklet;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//
///**
// * 비지니스 로직을 관리하는 Tasklet
// * but chunk 단위 트랜잭션 처리를 권장 함
// * 단순한 로직은 tasklet 사용 가능
// */
//@Slf4j
//public class TutorialTasklet implements Tasklet {
//
//    // 비지니스 로직 작성 부분
//    @Override
//    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//        log.debug("executed tasklet !!");
//        log.debug("test tasklet2 !!");
//        return RepeatStatus.FINISHED;
//    }
//}
