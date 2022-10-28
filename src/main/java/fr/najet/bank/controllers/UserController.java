package fr.najet.bank.controllers;

import fr.najet.bank.entities.Role;
import fr.najet.bank.entities.User;
import fr.najet.bank.exception.ApiRequestException;
import fr.najet.bank.repositories.UserRepository;
import fr.najet.bank.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin()
@RestController
public class UserController {
  @Autowired
  UserRepository userRepository;
  @Autowired
  UserService userService;

  /**
   * Read - Get all users.
   *
   * @return -A List objet of user full filled
   */

  @GetMapping(value = "/users")
  public List<User> getUsers() {
    return userService.getUsers();
  }

  /**
   * Read - Get one user.
   *
   * @param id The id of the user
   * @return A user object full filled
   */
  @GetMapping(value = "/user/{id}")
  public User getUserById(@PathVariable int id) {
    User user = userService.getUser(id);
    if (user == null) {
      throw new ApiRequestException("Oops cannot get user with id " + id + " was not found");
    }
    return user;
  }


  /**
   * Create - create user.
   *
   * @return -A List objet of user full filled
   */
  @CrossOrigin()
  @PostMapping(value = "/user/add")
  @ResponseBody
  public User addUser(@RequestBody User user) throws Exception {
    return this.userService.createUser(user);
  }

  /**
   * Create - create role.
   *
   * @return -A Collection objet of role full filled
   */
  @PostMapping(value = "/role/add")
  @ResponseBody
  public Role addRole(@RequestBody Role role) throws Exception {
    return this.userService.createRole(role);
  }

  /**
   * Modify - modify a user.
   * @return user - The user is updated
   */
  @PutMapping(value = "/user/update")
  @ResponseBody
  public User updateUser(@RequestBody User user) throws Exception {
    return this.userService.updateUser(user);
  }

  /**
   * Delete - Delete a user.
   *
   * @param id - The id of the user to delete
   * @return user - The user is delete
   */
  @DeleteMapping("/user/{id}")
  @ResponseBody
  public ResponseEntity<Void> deleteUserById(@PathVariable int id) throws Exception {
    userService.deleteUserById(id);
    return ResponseEntity.noContent().build();
  }


  
}

