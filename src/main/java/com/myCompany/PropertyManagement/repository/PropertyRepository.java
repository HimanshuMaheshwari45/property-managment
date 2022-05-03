package com.myCompany.PropertyManagement.repository;

import com.myCompany.PropertyManagement.entity.PropertyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {
    //@Query("SELECT p FROM p WHERE p.userEntity.id = :userId")
    List<PropertyEntity> findAllByUserEntityId (@Param("userId") Long userId);


}
