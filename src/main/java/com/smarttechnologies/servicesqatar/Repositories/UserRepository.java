package com.smarttechnologies.servicesqatar.Repositories;

import com.smarttechnologies.servicesqatar.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

     void deleteUserById(Long idUser);

      Optional<User> findUserById(Long idUser);
}
