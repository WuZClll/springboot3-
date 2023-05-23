package com.bjpowernode.mybatis.mapper;

import com.bjpowernode.mybatis.po.Article;
import com.bjpowernode.mybatis.po.ArticleDetail;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

/**
 * 作者：北京动力节点 wanghe
 */
public interface ArticleOneToOneMapper {

  //一对一查询

  //查询文章详情
  @Select("""
      select id,article_id,content from article_detail
      where article_id = #{articleId}
      """)
  @Results({
      @Result(id = true, column = "id", property = "id"),
      @Result(column = "article_id", property = "articleId"),
      @Result(column = "content", property = "content")
  })
  ArticleDetail selectDetail(Integer articleId);


  //查询文章属性包含详情（内容）
  @Select("""
      select  id,user_id,title,summary,read_count,create_time,update_time
      from article where id = #{id}
            """)
  @Results({
      @Result(id = true, column = "id", property = "id"),
      @Result(column = "user_id", property = "userId"),
      @Result(column = "title", property = "title"),
      @Result(column = "summary", property = "summary"),
      @Result(column = "read_count", property = "readCount"),
      @Result(column = "create_time", property = "createTime"),
      @Result(column = "update_time", property = "updateTime"),
      @Result(column = "id", property = "articleDetail",
          one = @One(select = "com.bjpowernode.mybatis.mapper.ArticleOneToOneMapper.selectDetail",
                fetchType = FetchType.LAZY)
      )
  })
  //fetchType = FetchType.LAZY懒加载
  //select = 里面是方法的全限定名 用他的查询结果
  Article selectAllArticle(Integer id);


}
