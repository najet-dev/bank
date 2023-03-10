package fr.najet.bank.services;

import fr.najet.bank.entities.Role;
import fr.najet.bank.entities.User;
import fr.najet.bank.repositories.RoleRepository;
import fr.najet.bank.repositories.UserRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class UserService {
  @Autowired
  UserRepository userRepository;
  @Autowired
  RoleRepository roleRepository;

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public Role createRole(Role role) {
    return roleRepository.save(role);
  }

  public User getUser(int id) {
    return userRepository.findById(id);
  }

 /* public User getUser(UUID id) {
    Optional<User> maybeUser =  userRepository.findById(id);
    if(maybeUser.isPresent())
      return maybeUser.get();
    return null;
  }*/

  public User updateUser(User user) {
    return userRepository.save(user);
  }


  public void deleteUserById(int id) {
    userRepository.deleteById(id);
  }

}
