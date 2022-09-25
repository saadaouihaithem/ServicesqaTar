package com.smarttechnologies.servicesqatar.Repositories;

import com.smarttechnologies.servicesqatar.Entities.Operation;
import com.smarttechnologies.servicesqatar.Exception.EtBadRequestException;
import com.smarttechnologies.servicesqatar.Exception.EtResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {

    List<com.smarttechnologies.servicesqatar.Entities.Operation> findAll(Long userId, Long postId);

    com.smarttechnologies.servicesqatar.Entities.Operation findById(Long userId, Long postId, Long operationId) throws EtResourceNotFoundException;

    Long create(Long userId, Long categoryId, Double price, String rate, Long operationDate) throws EtBadRequestException;

    void update(Long userId, Long postId, Long  operationId, com.smarttechnologies.servicesqatar.Entities.Operation operation) throws EtBadRequestException;

    void removeById(Long userId, Long postId, Long  operationId) throws EtResourceNotFoundException;

    Optional<Operation> findByName(String Name);

}
