package jcorreaw.webapi.controller;

import jcorreaw.webapi.model.User;
import jcorreaw.webapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping()
    public List<User> getUsers() {
        return repository.findAll();
    }

    @GetMapping("/{username}")
    public User getOne(@PathVariable("username") String username) {
        return repository.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }

    @PostMapping()
    public void postUser(@RequestBody User user) {
        repository.save(user);
    }
}
