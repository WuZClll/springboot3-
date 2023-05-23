package com.bjpowernode.blog.model.param;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 作者：北京动力节点
 */
@Data
public class ArticleParam {
  //JSR303进行验证
  //分组
  public static  interface  AddArticle {};
  public static  interface  EditArticle {};

  @NotNull(message = "修改时必须有id",groups = { EditArticle.class})
  @Min(value = 1 ,message = "文章id大于{value}",groups = { EditArticle.class})
  private Integer id; //文章id

  @NotBlank(message = "请输入文章标题",groups = { AddArticle.class,EditArticle.class})
  @Size(min=2,max = 20,message = "文章标题在{min}-{max}",groups = { AddArticle.class,EditArticle.class})
  private String title;

  @NotBlank(message = "请输入文章副标题",groups = { AddArticle.class,EditArticle.class})
  @Size(min=10,max = 30,message = "文章副标题在{min}-{max}",groups = { AddArticle.class,EditArticle.class})
  private String summary;

  @NotBlank(message = "请输入文章内容",groups = { AddArticle.class,EditArticle.class})
  @Size(min=20,max = 8000,message = "文章内容至少{min}字，最多{max}字",groups = { AddArticle.class,EditArticle.class})
  private String content;
}
