package fr.najet.bank.services;

import fr.najet.bank.entities.User;
import fr.najet.bank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public  User getUser(int id){return userRepository.findById(id);}

    public User updateUser( User user) {return userRepository.save(user);}


    public void deleteUserById(int id){ userRepository.deleteById(id);}

}
