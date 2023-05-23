package com.bjpowernode.http.service;

import com.bjpowernode.http.model.Albums;
import com.bjpowernode.http.record.AlbumsRecord;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.HttpExchange;

/**
 * 作者：北京动力节点
 */
@HttpExchange(url = "https://jsonplaceholder.typicode.com/")
public interface AlbumsService {

  //查询专辑
  @HttpExchange(method = "GET",url = "/albums/{id}")
  Albums getById(@PathVariable Integer id);

  //使用Java Record
  //contentType = MediaType.APPLICATION_JSON_VALUE接口返回json数据
  @HttpExchange(method = "GET",url = "/albums/{id}",contentType = MediaType.APPLICATION_JSON_VALUE)
  AlbumsRecord getByIdReturnRecord(@PathVariable Integer id);

}
