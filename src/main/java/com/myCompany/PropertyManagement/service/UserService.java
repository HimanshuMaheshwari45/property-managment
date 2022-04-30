package com.myCompany.PropertyManagement.service;

import com.myCompany.PropertyManagement.dto.UserDTO;

public interface UserService {

    UserDTO register (UserDTO userDTO);
    UserDTO login (String email, String password);

}
