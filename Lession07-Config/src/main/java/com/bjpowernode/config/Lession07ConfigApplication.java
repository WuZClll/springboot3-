package com.bjpowernode.config;

import com.bjpowernode.config.pk10.Person;
import com.bjpowernode.config.pk6.NestAppBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

//在配置类加入注解@ImportResource 加载xml文件
@ImportResource(locations = { "classpath:/applicationContext.xml"})

//启用ConfigurationProperties， 属性是类的名字, 启用配置bean，不用单独给配置类注册bean
//@EnableConfigurationProperties({NestAppBean.class})

//扫描注解的包名， 其中绑定Bean注入到Spring容器
@ConfigurationPropertiesScan( basePackages = { "com.bjpowernode.config.pk6" ,"com.bjpowernode.config.pk8"} )
@SpringBootApplication
public class Lession07ConfigApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Lession07ConfigApplication.class, args);
        //测试pk10(@ImportResource加载xml文件)
        Person bean = run.getBean(Person.class);
        System.out.println("bean = " + bean);
    }

}
