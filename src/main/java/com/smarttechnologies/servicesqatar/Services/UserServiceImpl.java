package com.smarttechnologies.servicesqatar.Services;
import com.smarttechnologies.servicesqatar.Entities.User;
import com.smarttechnologies.servicesqatar.Exception.EtResourceNotFoundException;
import com.smarttechnologies.servicesqatar.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long idUser) {
         return userRepository.findUserById(idUser)
                .orElseThrow(() -> new EtResourceNotFoundException("User by idUser " + idUser + " was not found"));
    }

    @Override
    public void deleteUser(Long idUser) {

        userRepository.deleteUserById(idUser);

    }
}