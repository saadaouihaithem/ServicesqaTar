package com.smarttechnologies.servicesqatar.Services;

import com.smarttechnologies.servicesqatar.Entities.Operation;
import com.smarttechnologies.servicesqatar.Exception.EtBadRequestException;
import com.smarttechnologies.servicesqatar.Exception.EtResourceNotFoundException;
import com.smarttechnologies.servicesqatar.Repositories.OperationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


    @Service
    @Transactional
    public class OperationServiceImpl implements OperationService {

        private final OperationRepository operationRepository;

        public OperationServiceImpl(OperationRepository operationRepository) {
            this.operationRepository = operationRepository;
        }



        public List<Operation> fetchAllOperation(Long userId, Long postId) {
            return operationRepository.findAll(userId,postId);
        }


        public Operation fetchAllOperationById(Long  userId, Long  postId, Long  operationId) throws EtResourceNotFoundException {
            return operationRepository.findById(userId,postId,operationId);
        }


        public Operation addOperation(Long  userId, Long postId, Long  operationId, Double price, String rate, Long operationDate) throws EtBadRequestException {
            operationId = operationRepository.create(userId,postId,price,rate,operationDate);
            return operationRepository.findById(userId,postId,operationId);
        }


        public void updateOperation(Long  userId,Long postId, Long  operationId, Operation operation) throws EtBadRequestException {
            operationRepository.update(userId,postId,operationId,operation);
        }

        public void removeOperation(Long  userId, Long  postId, Long  operationId) throws EtResourceNotFoundException {
            operationRepository.removeById(userId,postId,operationId);

        }
}
