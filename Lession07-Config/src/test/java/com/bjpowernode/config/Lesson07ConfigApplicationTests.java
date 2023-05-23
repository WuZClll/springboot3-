package com.bjpowernode.config;

import com.bjpowernode.config.pk1.SomeService;
import com.bjpowernode.config.pk2.ReadConfig;
import com.bjpowernode.config.pk3.MultiConfigService;
import com.bjpowernode.config.pk4.MultiEnvService;
import com.bjpowernode.config.pk5.AppBean;
import com.bjpowernode.config.pk6.NestAppBean;
import com.bjpowernode.config.pk6.Security;
import com.bjpowernode.config.pk8.CollectionConfig;
import com.bjpowernode.config.pk9.Group;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lesson07ConfigApplicationTests {

  @Autowired
  private SomeService someService;


  @Autowired
  private ReadConfig readConfig;

  @Autowired
  private MultiConfigService multiConfigService;

  @Autowired
  private MultiEnvService envService;

  @Test
  void test01() {
    someService.printValue();
  }

  @Test
  void test02() {
    readConfig.print();
  }

  @Test
  void test03() {
    multiConfigService.print();
  }

 @Test
  void test04() {
    envService.print();
  }


  @Autowired
  private AppBean appBean;
  @Test
  void test05() {
    System.out.println("appBean = " + appBean.toString());
    System.out.println("appBean.getClass() = " + appBean.getClass());

  }

 @Autowired
  private NestAppBean nestAppBean;
  @Test
  void test06() {
    System.out.println("nestAppBean = " + nestAppBean);
  }


  @Autowired
  private Security security;
  @Test
  void test07(){
    System.out.println("security = " + security);
  }

  @Autowired
  private CollectionConfig collectionConfig;
  @Test
  void test08() {
    System.out.println("collectionConfig = " + collectionConfig);
  }
  @Autowired
  private Group group;
  @Test
  void test09() {
    System.out.println("group = " + group);
  }
}
