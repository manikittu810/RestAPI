package rest.webServices.restfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User user=service.findOne(id);
        if(user==null)
            throw new UserNotFoundException("id: "+id);
        return user;
    }

    //POST /users
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody  User user){
User savedUser = service.save(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
return ResponseEntity.created(location).build();
    }

}
