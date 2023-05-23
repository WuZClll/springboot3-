package com.bjpowernode.mybatis.provider;

/**
 * 作者：北京动力节点 wanghe
 * 提供者类
 */
public class SqlProvider {

  //定义静态方法
  public static String selectArticle(){
    return "select * from article where id=#{id}";
  }

  public static String updateSql(){
    return "update article set update_time=#{newTime} where id=#{id}";
  }

  public static  String insertSql(){
    return """
         insert into article(user_id,title,summary,read_count,create_time,update_time)
         values(#{userId},#{title},#{summary},#{readCount},#{createTime},#{updateTime})
        """;
  }

  public static String deleteSql(){
    return """
        delete from article where id=#{articleId}
        """;
  }

}
