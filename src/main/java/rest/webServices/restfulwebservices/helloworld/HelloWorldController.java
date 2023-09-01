package rest.webServices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//RestAPI
@RestController
public class HelloWorldController {
    @GetMapping(path="/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean HelloWorldBean(){
        return  new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}") //path parameters /users/1/path-variable/{name}
    public HelloWorldBean helloWorlPathVariable(@PathVariable String name){
//        return  new HelloWorldBean("Hello World" + name);
        return new HelloWorldBean(String.format("Hello World, %s",name));
    }

}
