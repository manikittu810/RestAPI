package rest.webServices.restfulwebservices.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {
    //Get /users
    private userDaoService service;
    public UserResource(userDaoService service){
        this.service=service;

    }
//    GET /users
    @GetMapping("/users")
    public List<User> retrieveUsers(){
        return service.findAll();
    }
    //GET a single user
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return service.findOne(id);
    }

    //POST /users
    @PostMapping("/users")
    public void createUser(@RequestBody  User user){
service.save(user);
    }

}
