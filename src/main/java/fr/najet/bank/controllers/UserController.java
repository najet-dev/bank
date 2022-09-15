package fr.najet.bank.controllers;

import fr.najet.bank.dto.UserDto;
import fr.najet.bank.entities.User;
import fr.najet.bank.exception.ApiRequestException;
import fr.najet.bank.repositories.ClientRepository;
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
    ClientRepository clientRepository;

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
     * Create - create a user
     * @return -A List objet of user full filled
     */
    @PostMapping(value="/users/get")
    public User UserByUserName(@RequestBody UserDto userDto) throws Exception{
        User user = userRepository.findByUserName(userDto.getUserName());
        return user;
    }
    /**
     * Read - Get one user
     * @param id The id of the user
     * @return A user object full filled
     */
    @GetMapping(path = "/users/{id}")
    public User getUserById(@PathVariable(value="id") int id){
        User user = userService.getUser(id) ;
        if(user == null) throw new ApiRequestException("Oops cannot get user with id "+ id  + " was not found");
        return this.userService.getUser(id);
    }
    /**
     * Create - create a user
     * @return -A List objet of user full filled
     */
    @PostMapping(value = "/users/add")
    @ResponseBody
    public List<User> addUser(@RequestBody UserDto userDto) throws Exception{
        try{
            List<User> userList = userRepository.findAll();
            return  userList;
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
    /**
     * Modify - modify a user
     * @return user - The user is updated
     */
    @PutMapping("/users")
    @ResponseBody
    public List<User> updateUser(@RequestBody UserDto userDto)throws Exception{
        try{
            User user = UserDto.addUser(userDto);
            userService.updateUser(user);
            List<User> users = userService.getUsers();
            return  users;
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
    /**
     * Delete - Delete a user
     * @param id - The id of the user to delete
     * @return user - The user is deleted
     */
    @DeleteMapping("/users/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteUserById(@PathVariable int id) throws Exception{
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}

