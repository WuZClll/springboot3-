package com.bjpowernode.mybatis.mapper;

import com.bjpowernode.mybatis.po.ArticlePO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 作者：北京动力节点 wanghe
 */
public interface ArticleMapper {

  //按主键查询
  //查询结果ResultSet 和 PO对象的属性映射
  @Results(id = "BaseArticleMap", value =  {
      @Result( id = true ,column = "id" ,property = "id"),
      @Result(column = "user_id",property = "userId"),
      @Result(column = "title",property = "title"),
      @Result(column = "summary" ,property = "summary"),
      @Result(column = "read_count",property = "readCount"),
      @Result(column = "create_time",property = "createTime"),
      @Result(column = "update_time",property = "updateTime")
  })
  @Select("""
      select id,user_id,title,summary,read_count,create_time,update_time
      from article where id = #{articleId}
      """)
  ArticlePO selectById(@Param("articleId") Integer id);


  //insert
  @Insert("""
      insert into article(user_id,title,summary,read_count,create_time,update_time)
      values(#{userId},#{title},#{summary},#{readCount},#{createTime},#{updateTime})
      """)
  int insertArticle(ArticlePO po);

  //update  是参数名可以作为占位符 #{形参名} 在3.4.3版本以后可以不加@param注解，非常方便
  @Update("""
      update article set read_count=#{readCount} where id=#{id}
      """)
  int updateReadCount(Integer id,Integer readCount);


  //删除
  @Delete("""
      delete from article where id = #{id}
      """)
  int deleteById(Integer id);

}
