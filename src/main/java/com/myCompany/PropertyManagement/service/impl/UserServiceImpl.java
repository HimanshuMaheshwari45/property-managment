package com.myCompany.PropertyManagement.service.impl;


import com.myCompany.PropertyManagement.converter.UserConverter;
import com.myCompany.PropertyManagement.dto.UserDTO;
import com.myCompany.PropertyManagement.entity.UserEntity;
import com.myCompany.PropertyManagement.repository.UserRepository;
import com.myCompany.PropertyManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        userDTO = userConverter.convertEntitytoDYO(userEntity);

        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }
}
