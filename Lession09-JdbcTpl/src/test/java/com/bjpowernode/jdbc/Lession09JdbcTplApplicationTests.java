package com.bjpowernode.jdbc;

import com.bjpowernode.jdbc.model.ArticleDetailPO;
import com.bjpowernode.jdbc.model.ArticleMainPO;
import com.bjpowernode.jdbc.model.ArticlePO;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@SpringBootTest
class Lession09JdbcTplApplicationTests {


  //注入JdbcTemplate
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Test
  void test01() {
    String sql="select count(*) as ct from article";
    //查不出来会报错
    Long count = jdbcTemplate.queryForObject(sql, Long.class);
    System.out.println("记录行数 = " + count);
  }

  //查询结果为单行记录， 使用 ？ 作为参数占位符
  @Test
  void test02() {
    String sql="select * from article where id=?";
    //查不出来会报错
    ArticlePO articlePO = jdbcTemplate.queryForObject(sql,
        new BeanPropertyRowMapper<>(ArticlePO.class), 1);
    System.out.println("articlePO = " + articlePO);
  }

  @Test
  void testRowMapper(){
    String sql = "select * from article where id = 1";
    //查不出来会报错
    ArticlePO articlePO = jdbcTemplate.queryForObject(sql, (rs, rownum) -> {
      //从rs获取列值
      var id = rs.getInt("id");
      var userId = rs.getInt("user_id");
      var title = rs.getString("title");
      var summary = rs.getString("summary");
      var readCount = rs.getInt("read_count");
      var createTime = new Timestamp(rs.getTimestamp("create_time").getTime()).toLocalDateTime();
      var updatetime = new Timestamp(rs.getTimestamp("update_time").getTime()).toLocalDateTime();
      return new ArticlePO(id, userId, title, summary, readCount, createTime, updatetime);
    });
    System.out.println("po="+articlePO.toString());
  }



  @Test
  void testList() {
    String sql="select * from article where id = 1 order by id";
    //一个list成员一行记录， Map是列名和值
    //查不出来不会报错
    List<Map<String, Object>> listMap = jdbcTemplate.queryForList(sql);
    listMap.forEach( el-> {
      el.forEach( (field,value) -> {
        System.out.println("字段名称："+field + ",列值："+ value);
      });
      System.out.println("=================");
    });



  }


  @Test
  void testUpdate() {
    String sql="update article set title = ? where id = ?";
    int rows  = jdbcTemplate.update(sql,"Java编程思想",2);
    System.out.println("rows = " + rows);
  }

  @Autowired
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Test
  void testNameParameter() {
    String sql="select count(*) as ct from article where user_id=:uid and read_count > :num";
    //给参数赋值
    Map<String,Object> param = new HashMap<>();
    param.put("uid", 2101);
    param.put("num", 10);

    Long readCounts = namedParameterJdbcTemplate.queryForObject(sql, param, Long.class);
    System.out.println("readCounts = " + readCounts);


  }


  /**
   * 多表查询
   */
  @Test
  void testQueryContent() {
    String sql= """
        select m.*, d.id as detail_id , d.article_id ,d.content
        from article m join article_detail d 
        on m.id = d.article_id
        where m.id = :id
        """;
    Map<String,Object> param  = new HashMap<>();
    param.put("id",1);

    List<ArticleMainPO> mainList = namedParameterJdbcTemplate.query(sql,param, (rs,num)->{
      var id = rs.getInt("id");
      var userId = rs.getInt("user_id");
      var title = rs.getString("title");
      var summary = rs.getString("summary");
      var readCount = rs.getInt("read_count");
      var createTime = new Timestamp(rs.getTimestamp("create_time").getTime()).toLocalDateTime();
      var updatetime = new Timestamp(rs.getTimestamp("update_time").getTime()).toLocalDateTime();

      //文章内容
      var content = rs.getString("content");
      var detailId = rs.getInt("detail_id");
      var articleId = rs.getInt("article_id");

      ArticleDetailPO detailPO  = new ArticleDetailPO(detailId,articleId,content);

      return  new ArticleMainPO(id,userId,title,summary,readCount
      ,createTime,updatetime,detailPO);

    });

    mainList.forEach( m->{
      Integer id = m.getId();
      System.out.println("id = " + id);

      System.out.println("m.getDetail() = " + m.getDetail());

    });


  }
}
