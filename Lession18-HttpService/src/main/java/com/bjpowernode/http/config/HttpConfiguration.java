package com.bjpowernode.http.config;

import com.bjpowernode.http.service.AlbumsService;
import com.bjpowernode.http.service.TodoService;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

/**
 * 作者：北京动力节点
 */
@Configuration(proxyBeanMethods = false)
public class HttpConfiguration {

  //创建服务接口的Todo的代理对象，基于WebClient
  @Bean
  public TodoService requestService(){
    WebClient webClient =
        WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();

    //创建代理工厂
    HttpServiceProxyFactory proxyFactory=
        HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();

    //创建某个接口的代理服务
    return proxyFactory.createClient(TodoService.class);
  }

  //创建Albums的代理
  /*@Bean
  public AlbumsService albumsService(){
    WebClient webClient = WebClient.create();
    HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory
        .builder(WebClientAdapter.forClient(webClient)).build();

    return proxyFactory.createClient(AlbumsService.class);
  }*/


  //定制Http服务
  @Bean
  public AlbumsService albumsService(){
    //超时
    HttpClient httpClient = HttpClient.create()
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS,30000) //连接时间
        .doOnConnected( conn -> {
          conn.addHandlerLast(new ReadTimeoutHandler(10));//读超时
          conn.addHandlerLast(new WriteTimeoutHandler(10) );//写超时
        });

    //设置异常
    WebClient webClient = WebClient.builder()
        .clientConnector(new ReactorClientHttpConnector(httpClient))
        .defaultStatusHandler(HttpStatusCode::isError, clientResponse -> {
          System.out.println("*********WebClient请求异常***********");
          return Mono.error( new RuntimeException("请求异常" + clientResponse.statusCode().value()));
        }).build();




    HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory
        .builder(WebClientAdapter.forClient(webClient)).build();

    return proxyFactory.createClient(AlbumsService.class);
  }

}
