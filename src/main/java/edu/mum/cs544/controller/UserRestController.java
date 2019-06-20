package edu.mum.cs544.controller;

import edu.mum.cs544.service.UserService;
import edu.mum.cs544.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users", produces = "application/json")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping(value = "/users/{id}",produces = "application/json")
    public User get(@PathVariable Long id){
        return userService.get(id);
    }

    @PostMapping(value = "/users",consumes = "application/json")
    public RedirectView post(@RequestBody User user){
        userService.add(user);
        return new RedirectView("/users/" + user.getId());
    }

    @PutMapping(value = "/users/{id}",consumes = "application/json")
    public void put(@PathVariable int id, @RequestBody User user){
        if (id!=user.getId()){
            throw new IllegalArgumentException();
        }

        userService.update(user);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @GetMapping("/users/{email}/{password}")
    public User CheckEmailAndPassword(@PathVariable String email, @PathVariable String password){
        return userService.CheckUserAndPassword(email,password);
    }

}
