package com.bjpowernode.problem.exp;

/**
 * 作者：北京动力节点
 */
public class BookNotFoundException  extends RuntimeException{

  public BookNotFoundException() {
    super();
  }

  public BookNotFoundException(String message) {
    super(message);
  }
}
