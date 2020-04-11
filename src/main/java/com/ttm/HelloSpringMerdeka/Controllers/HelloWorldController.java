package com.ttm.HelloSpringMerdeka.Controllers;

import com.ttm.HelloSpringMerdeka.Config;
import com.ttm.HelloSpringMerdeka.Entity.Company;
import com.ttm.HelloSpringMerdeka.Entity.Todo;
import com.ttm.HelloSpringMerdeka.Entity.UserName;
import org.apache.catalina.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Arrays;

@RestController
public class HelloWorldController {

    @GetMapping("/company")
    public Company home(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Company company = context.getBean("company", Company.class);

        return company;
    }

    RestTemplate restTemplate = new RestTemplate();
    // run in web browser http://localhost:8080/todo/get
    @GetMapping("/todo/get")
    public String getTodo(){
        String result = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos", String.class);
        return result;
    }
    // run in web browser http://localhost:8080/todo/post
    @GetMapping("/todo/post")
    public String postTodo(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        Todo newTodo = new Todo();
        newTodo.setId((long)1000);
        newTodo.setTitle("Charlie");
        newTodo.setUserId((long)9);
        newTodo.setCompleted(false);
        HttpEntity<Todo> entity = new HttpEntity<Todo>(newTodo, headers);
        return restTemplate.exchange("https://jsonplaceholder.typicode.com/todos", HttpMethod.POST, entity,
                String.class).getBody();
    }

    // run in web browser http://localhost:8080/todo/delete
    @GetMapping("/todo/delete")
    public String deleteTodo(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        Todo newTodo = new Todo();
        newTodo.setId((long) 1);

        HttpEntity<Todo> entity = new HttpEntity<Todo>(newTodo, headers);
        return restTemplate.exchange("https://jsonplaceholder.typicode.com/todos/"+newTodo.getId(), HttpMethod.DELETE, entity,
                String.class).getBody();
    }

    // run in web browser http://localhost:8080/todo/put/{}
    @GetMapping("/todo/put/{id}")
    public String putTodo(@PathVariable("id") String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        Todo newTodo = new Todo();
        newTodo.setTitle("John Wick");
        newTodo.setCompleted(true);

        HttpEntity<Todo> entity = new HttpEntity<Todo>(newTodo, headers);
        return restTemplate.exchange("https://jsonplaceholder.typicode.com/todos/" +id, HttpMethod.PUT, entity,
                String.class).getBody();
    }

    // run in web http://localhost:8080/HelloWorld
    @GetMapping("/HelloWorld")
    public String HelloWorld(){
        return "Hello World";
    }

    //run in web browser http://localhost:8080/HelloWorld/jim
    @GetMapping("/HelloWorld/{name}")
    public String HelloWorldName(@PathVariable(value = "name") String name){
        return "hello "+name;
    }
    // run from POSTMAN with UserName
    @PostMapping("/HelloWorld")
    public String HelloWorldPostController(@RequestParam(value = "UserName") String username){
        return "hello from post. Your UserName is "+username;
    }
    // run from POSTMAN with Body - JSON
    @PostMapping("/HelloWorldUser")
    public UserName HelloWorldUserPostController(@Valid @RequestBody UserName userName){
        return userName;
    }

}
