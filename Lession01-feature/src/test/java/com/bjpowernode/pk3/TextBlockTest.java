package com.bjpowernode.pk3;

import org.junit.Test;

/**
 * @author 动力节点 wanghe
 */
public class TextBlockTest {

  @Test
  public void test01() {
    //文本块
    String s1 = """
        hello world
        select * from daul join aa
        on aa.id = xx.id
        where aa.id = 1
        order by id desc
        """;

    //String s2= """lisi""";
/*    String s22= """lisi
""";*/
    String s3= """
        zhangsan""";

  }

  @Test
  public void test02() {
    String s1 = """
        lisi
        """;

    String s2 = """
        lisi
        """;

    boolean flag = s1.equals(s2);
    System.out.println("flag = " + flag);


    boolean f = s1 == s2;
    System.out.println("f = " + f);

    String msg = """
        hello world;
        """;
    String str = msg.substring(0, 5);
    System.out.println("str = " + str);
  }

  @Test
  public void test03() {
    String msg = """
          <html>
          <body>Java黄埔军校</body>
          </html>
        """;

    System.out.println(msg);



  }

  @Test
  public void test04() {
    String colors = """
        red
        green
        blue
        """;

    //indent缩进 行首缩进15个空格
    colors = colors.indent(15);
    System.out.println( colors);
  }

  @Test
  public void test05() {
    //格式化
    String info = """
        Name:%s,
        Phone:%s
        Age:%d
        """.formatted("李四","13800000000",20);
    System.out.println( info);
  }

  @Test
  public void test06() {
//    \转义及换行(这里的换行输出时不会换行，这里的斜线会当空格来用)
    String info = """
        Spring Boot是一个快速开发框架 \
        是\"Spring\"家族的一个成员 \
        创建spring项目
        """;
    System.out.println(info);
  }

  @Test
  public void test07() {
    var s1="hello";
    var i = 10 ;



  }
}
