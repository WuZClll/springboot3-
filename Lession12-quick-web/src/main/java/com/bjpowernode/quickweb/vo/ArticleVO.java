package com.bjpowernode.quickweb.vo;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 作者：北京动力节点 wanghe
 */
@Data
public class ArticleVO {

  //组就是接口名，
  public static interface AddArticleGroup{};
  public static interface EditArticleGroup{};


  @NotNull(message = "文章id必须有值",groups = {EditArticleGroup.class})
  @Min(value = 1,message = "id大于0",groups = { EditArticleGroup.class })
  private Integer id;

  @NotNull(message = "必须有作者",groups = { AddArticleGroup.class,EditArticleGroup.class})
  private Integer userId;

  @NotBlank(message = "文章必须有标题",
      groups = {AddArticleGroup.class,EditArticleGroup.class})
  //@Size 认为 null是有效值。
  @Size(min = 3,max = 30,message = "标题在3个字符以上",
      groups = {AddArticleGroup.class,EditArticleGroup.class})
  private String title;

  @NotBlank(message = "必须有副标题",
      groups = {AddArticleGroup.class,EditArticleGroup.class})
  @Size(min = 5,max = 60,message = "副标题在5个字以上",
      groups = {AddArticleGroup.class,EditArticleGroup.class})
  private String summary;

  @DecimalMin(value = "0",message = "阅读数量不能小于0"
      ,groups = {AddArticleGroup.class,EditArticleGroup.class})
  private Integer readCount;

  @Email(message = "邮箱不符合规则",groups = {AddArticleGroup.class,EditArticleGroup.class})
  private String email;
}
