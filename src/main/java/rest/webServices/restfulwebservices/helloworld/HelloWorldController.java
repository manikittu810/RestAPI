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
    public helloWorldBean helloWorldBean(){
        return  new helloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}") //path parameters /users/1/path-variable/{name}
    public helloWorldBean helloWorlPathVariable(@PathVariable String name){
//        return  new helloWorldBean("Hello World" + name);
        return new helloWorldBean(String.format("Hello World, %s",name));
    }

}
