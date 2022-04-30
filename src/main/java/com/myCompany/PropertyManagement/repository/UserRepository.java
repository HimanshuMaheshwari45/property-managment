package com.myCompany.PropertyManagement.repository;

import com.myCompany.PropertyManagement.entity.PropertyEntity;
import com.myCompany.PropertyManagement.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {


}
