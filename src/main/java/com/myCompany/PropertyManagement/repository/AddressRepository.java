package com.myCompany.PropertyManagement.repository;

import com.myCompany.PropertyManagement.entity.AddressEntity;
import com.myCompany.PropertyManagement.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<AddressEntity, Long> {
}
