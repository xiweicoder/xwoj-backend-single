package com.xwoj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import static com.xwoj.mq.CodeMqInitMain.doInitCodeMq;

/**
 * 主类（项目启动入口）
 *
 * @author 西尾coding
 */
// todo 如需开启 Redis，须移除 exclude 中的内容
// @SpringBootApplication(exclude = {RedisAutoConfiguration.class})
@SpringBootApplication()
@MapperScan("com.xwoj.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class XWMainApplication {

    public static void main(String[] args) {
        doInitCodeMq();
        SpringApplication.run(XWMainApplication.class, args);
    }

}
