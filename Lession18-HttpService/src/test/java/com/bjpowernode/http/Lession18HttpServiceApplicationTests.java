package com.bjpowernode.http;

import com.bjpowernode.http.model.Todo;
import com.bjpowernode.http.service.TodoService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class Lession18HttpServiceApplicationTests {


	//注入代理对象
	@Resource
	private TodoService todoService;


	//测试访问todos/1
	@Test
	void testQuery() {
		Todo todo = todoService.getTodoById(2);
		System.out.println("todo = " + todo);

		//class jdk.proxy2.$Proxy52
		System.out.println("todoService = " + todoService.getClass());
		Integer id = todo.getId();
		Integer userId = todo.getUserId();
	}

	//创建资源
	@Test
	void testCreateTodo(){
		Todo todo = new Todo();
		todo.setId(1001);
		todo.setUserId(5005);
		todo.setTitle("事项1");
		todo.setCompleted(true);

		Todo resultTodo = todoService.createTodo(todo);
		System.out.println("resultTodo = " + resultTodo);
	}

	@Test
	void testModify() {
		Todo todo = new Todo();
		todo.setId(1002);
		todo.setUserId(5002);
		todo.setTitle("事项2");
		todo.setCompleted(true);

		ResponseEntity<Todo> entity = todoService.modifyTodo(2, todo);

		HttpHeaders headers = entity.getHeaders();
		System.out.println("headers = " + headers);

		Todo body = entity.getBody();
		System.out.println("body = " + body);

		HttpStatusCode statusCode = entity.getStatusCode();
		System.out.println("statusCode = " + statusCode);

	}

	@Test
	void testDelete() {
		todoService.removeTodo(10);
	}
}
