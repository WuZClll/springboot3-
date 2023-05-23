package com.bjpowernode.http;

import com.bjpowernode.http.model.Albums;
import com.bjpowernode.http.record.AlbumsRecord;
import com.bjpowernode.http.service.AlbumsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 作者：北京动力节点
 */
@SpringBootTest
public class TestAlbumsService {

  //专辑服务
  @Autowired
  private AlbumsService albumsService;

  @Test
  void testQuery() {
    Albums albums = albumsService.getById(5);
    System.out.println("albums = " + albums);
  }

  @Test
  void testRecord() {
    try{
      AlbumsRecord record = albumsService.getByIdReturnRecord(222);
      System.out.println("record = " + record);
      String title = record.title();
    }catch (Exception e){
      e.printStackTrace();
    }

  }
}
