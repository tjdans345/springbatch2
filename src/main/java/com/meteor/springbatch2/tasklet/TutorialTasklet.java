package com.meteor.springbatch2.tasklet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

@Slf4j
public class TutorialTasklet implements Tasklet {

    // 비지니스 로직 작성 부분
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.debug("executed tasklet !!");
        return RepeatStatus.FINISHED;
    }
}
