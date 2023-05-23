package com.bjpowernode.blog.fomatter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

/**
 * 作者：北京动力节点
 * 解析ids参数
 */
public class IdTypeFormatter  implements Formatter<IdType> {

  @Override
  public IdType parse(String text, Locale locale) throws ParseException {
    IdType idType = null;
    if(StringUtils.hasText(text)){
      List<Integer> ids = new ArrayList<>();
      for(String id: text.split(",")){
        ids.add(Integer.parseInt(id));
      }
      idType = new IdType();
      idType.setIdList(ids);
    }
    return idType;
  }

  @Override
  public String print(IdType object, Locale locale) {
    return null;
  }
}
