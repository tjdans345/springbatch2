package com.meteor.springbatch2;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableBatchProcessing // 배치 기능 활성화
@SpringBootApplication
public class Springbatch2Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbatch2Application.class, args);
    }

}
