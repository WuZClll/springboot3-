package com.bjpowernode.config.pk8;

/**
 * 作者：北京动力节点 wanghe
 */
public class MyServer {

  private String title;
  private String ip;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  @Override
  public String toString() {
    return "MyServer{" +
           "title='" + title + '\'' +
           ", ip='" + ip + '\'' +
           '}';
  }
}
