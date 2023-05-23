package com.bjpowernode.problem.controller;

import com.bjpowernode.problem.config.BookContainer;
import com.bjpowernode.problem.exp.BookNotFoundException;
import com.bjpowernode.problem.exp.IsbnNotFoundException;
import com.bjpowernode.problem.model.BookRecord;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：北京动力节点
 */
@RestController
public class BookController {

  //注入BookContainer
  @Autowired
  private BookContainer bookContainer;

  //根据isbn查询图书，如果没有查询到，抛出异常
  @GetMapping("/book")
  public BookRecord getBook(String isbn) {

    Optional<BookRecord> bookRecord = bookContainer.getBooks().stream().filter(el ->
      el.isbn().equals(isbn)
    ).findFirst();

    if( bookRecord.isEmpty() ){
//      throw new BookNotFoundException(" isbn :" + isbn + "->没有此图书");
      throw new IsbnNotFoundException(HttpStatus.NOT_FOUND,"====isbn :" + isbn + "->没有此图书=====");
    }
    return bookRecord.get();
  }

}
