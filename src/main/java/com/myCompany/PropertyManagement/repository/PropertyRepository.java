package com.myCompany.PropertyManagement.repository;

import com.myCompany.PropertyManagement.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {


}
