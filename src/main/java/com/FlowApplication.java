package com;

import com.flowable.conf.AppDispatcherServletConfiguration;
import com.flowable.conf.ApplicationConfiguration;
import org.flowable.ui.modeler.conf.DatabaseConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//启用全局异常拦截器
@Import(value={
  // 引入修改的配置
  ApplicationConfiguration.class,
  AppDispatcherServletConfiguration.class,
  // 引入 DatabaseConfiguration 表更新转换
  DatabaseConfiguration.class})
// Eureka 客户端
@ComponentScan(basePackages = {"com.*"})
@MapperScan("com.springcloud.*.dao")
// 移除 Security 自动配置
// Spring Cloud 为 Finchley 版本
// @SpringBootApplication(exclude={SecurityAutoConfiguration.class})
// Spring Cloud 为 Greenwich 版本
@SpringBootApplication(exclude={SecurityAutoConfiguration.class, SecurityFilterAutoConfiguration.class})
public class FlowApplication {
  public static void main(String[] args) {
    SpringApplication.run(FlowApplication.class, args);
  }
}

