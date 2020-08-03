package com.qssy.exam.webexam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zzz
 */
@SpringBootApplication
@MapperScan("com.qssy.exam.webexam.dao")
public class WebExamApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebExamApplication.class, args);
    }
}
