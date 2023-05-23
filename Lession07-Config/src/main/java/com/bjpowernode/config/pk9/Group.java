package com.bjpowernode.config.pk9;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 作者：北京动力节点 wanghe
 */
@Configuration//创建对象到容器
@ConfigurationProperties(prefix = "group")//前缀group
@PropertySource(value = "classpath:/conf/group-info.properties")//配置来源
public class Group {

  private String name;
  private String leader;
  private Integer members;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLeader() {
    return leader;
  }

  public void setLeader(String leader) {
    this.leader = leader;
  }

  public Integer getMembers() {
    return members;
  }

  public void setMembers(Integer members) {
    this.members = members;
  }

  @Override
  public String toString() {
    return "Group{" +
           "name='" + name + '\'' +
           ", leader='" + leader + '\'' +
           ", members=" + members +
           '}';
  }
}
