package org.lanqiao.ssm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("org.lanqiao.ssm.mapper")
@SpringBootApplication
public class Springboot03SsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03SsmApplication.class, args);
    }

}

