package com.bjpowernode.mybatis.mapper;

import com.bjpowernode.mybatis.po.ArticlePO;
import com.bjpowernode.mybatis.provider.SqlProvider;
import java.time.LocalDateTime;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * 作者：北京动力节点 wanghe
 */
public interface ArticleRepository {

  //定义@Results
  @Select("")
  @Results(id = "NewBaseArticleMap", value = {
      @Result(id = true, column = "id", property = "id"),
      @Result(column = "user_id", property = "userId"),
      @Result(column = "title", property = "title"),
      @Result(column = "summary", property = "summary"),
      @Result(column = "read_count", property = "readCount"),
      @Result(column = "create_time", property = "createTime"),
      @Result(column = "update_time", property = "updateTime")
  })
  ArticlePO articleMapper();


  //使用提供者
  @ResultMap("NewBaseArticleMap")
  /**
   * type: 提供者类
   * updateSql：提供者类中的方法语句
   */
  @SelectProvider(type = SqlProvider.class,method = "selectArticle")
  ArticlePO selectByPrimary(Integer id);


  @UpdateProvider(type = SqlProvider.class,method = "updateSql")
  int updateTime(Integer id, LocalDateTime newTime);


  @InsertProvider(type = SqlProvider.class,method = "insertSql")
  int insertArticle(ArticlePO po);

  @DeleteProvider(type = SqlProvider.class,method = "deleteSql")
  int deleteById(Integer id);

}
