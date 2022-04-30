package com.myCompany.PropertyManagement.service.impl;

import com.myCompany.PropertyManagement.converter.UserConverter;
import com.myCompany.PropertyManagement.dto.UserDTO;
import com.myCompany.PropertyManagement.entity.UserEntity;
import com.myCompany.PropertyManagement.repository.UserRepository;
import com.myCompany.PropertyManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {

        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);

        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.convertEntityToDTO(userEntity);

        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {

        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmailAndPassword(email, password);
        UserDTO userDTO = null;
        if(optionalUserEntity.isPresent()){
            userDTO = userConverter.convertEntityToDTO(optionalUserEntity.get());
        }
        return userDTO;
    }
}