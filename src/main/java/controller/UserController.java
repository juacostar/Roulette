package controller;

import model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.UserRepository;
import request.UserRequest;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "user/create")
    public ResponseEntity<Void> createUser(@RequestBody UserRequest userRequest){
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setMoney(userRequest.getMoney());
        this.userRepository.save(user);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "user/{id}")
    public  ResponseEntity<User> getUser(@PathVariable Integer id){
        User user= this.userRepository.findById(id);
        if(user == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return  ResponseEntity.ok().body(user);
    }

    @PutMapping(path = "user/update/{id}")
    public  ResponseEntity<Void> updateUser(@PathVariable Integer id, @RequestBody UserRequest userRequest){
        User user = this.userRepository.findById(id);
        if(user == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setMoney(userRequest.getMoney());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
