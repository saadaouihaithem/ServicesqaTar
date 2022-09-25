package com.smarttechnologies.servicesqatar.Services;

import com.smarttechnologies.servicesqatar.Entities.User;
import com.smarttechnologies.servicesqatar.Exception.EtAuthException;

import java.util.List;

public interface UserService {

    User addUser(User user);

    List<User> findAllUser();
    User updateUser(User user);
    User findUserById(Long idUser);
    void deleteUser(Long idUser);
}
