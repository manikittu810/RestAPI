package rest.webServices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//RestAPI
@RestController
public class HelloWorldController {
    @GetMapping(path="/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
}
