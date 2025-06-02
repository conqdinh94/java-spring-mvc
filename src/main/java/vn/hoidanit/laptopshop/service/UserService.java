package vn.hoidanit.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public List<User> getAllUserByEmail(String email) {
        return userRepository.findAllUserByEmail(email);
    }

    public List<User> getAllUserByEmailAndAddress(String email, String address) {
        return userRepository.findAllUserByEmailAndAddress(email, address);
    }

    public User handSaveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(int id) {
        return userRepository.findById(id);
    }

    public void deleteUserById(int id) {
        this.userRepository.deleteById(id);
    }

}
