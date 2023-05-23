package com.bjpowernode.mvc.controller;

import com.bjpowernode.mvc.model.DeviceInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：北京动力节点
 */
@RestController
public class DeviceController {

  @PostMapping("/device/add")
  public String addDeviceInfo(@RequestParam("device") DeviceInfo info){
    return "接收的设备信息："+info.toString();
  }
}
