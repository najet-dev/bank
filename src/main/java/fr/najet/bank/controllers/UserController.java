package fr.najet.bank.controllers;

import fr.najet.bank.dto.UserDto;
import fr.najet.bank.entities.User;
import fr.najet.bank.exception.ApiRequestException;
import fr.najet.bank.repositories.UserRepository;
import fr.najet.bank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    /**
     * Read - Get all users
     * @return -A List objet of user full filled
     */
    @GetMapping(value="/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    /**
     * Read - Get one user
     * @param id The id of the user
     * @return A user object full filled
     */
    @GetMapping(value = "/users/{id}")
    public User getUserById(@PathVariable int id){
        User user = userService.getUser(id) ;
        if(user == null) throw new ApiRequestException("Oops cannot get user with id "+ id  + " was not found");
        return user;
    }
    @PostMapping(value = "/users/add")
    @ResponseBody
    public User addUser(@RequestBody User user) throws Exception {
        return this.userService.createUser(user);
    }
    @PostMapping(value = "/user/add")
    public User createUser(@RequestBody UserDto userDto) throws Exception {

        User createdUser = null;
        createdUser = new User(userDto.getLastName(), userDto.getFirstName(), userDto.getEmail(), userDto.getUserName(), userDto.getRole(), userDto.getPassword());
        userRepository.save((User) createdUser);

        return createdUser;
    }

    /**
     * Modify - modify a user
     * @return user - The user is updated
     */
    @PutMapping(value = "/user/update")
    @ResponseBody
    public User updateUser(@RequestBody User user) throws Exception {
        return this.userService.updateUser(user);
    }
    /**
     * Delete - Delete a user
     * @param id - The id of the user to delete
     * @return user - The user is delete
     */
    @DeleteMapping("/users/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteUserById(@PathVariable int id) throws Exception{
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}

