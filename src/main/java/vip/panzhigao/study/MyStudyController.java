package vip.panzhigao.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by panzhigao on 2019/8/30.
 */
@SpringBootApplication
@ComponentScan({"vip.panzhigao.study.service","vip.panzhigao.study.controller"})
@MapperScan("vip.panzhigao.study.mapper")
public class MyStudyController {

    public static void main(String[] args) {
        SpringApplication.run(MyStudyController.class);
    }

}
