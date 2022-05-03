package com.myCompany.PropertyManagement.service.impl;

import com.myCompany.PropertyManagement.converter.PropertyConverter;
import com.myCompany.PropertyManagement.dto.PropertyDTO;
import com.myCompany.PropertyManagement.entity.PropertyEntity;
import com.myCompany.PropertyManagement.entity.UserEntity;
import com.myCompany.PropertyManagement.exception.BusinessException;
import com.myCompany.PropertyManagement.exception.ErrorModel;
import com.myCompany.PropertyManagement.repository.PropertyRepository;
import com.myCompany.PropertyManagement.repository.UserRepository;
import com.myCompany.PropertyManagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
    public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;
    @Autowired
    private UserRepository userRepository;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        Optional<UserEntity> optUE =  userRepository.findById(propertyDTO.getUserId());
        if(optUE.isPresent()) {
            PropertyEntity pe = propertyConverter.propertyDTOToPropertyEntity(propertyDTO);
            pe.setUserEntity(optUE.get());
            pe = propertyRepository.save(pe);

            propertyDTO = propertyConverter.propertyEntityToDTO(pe);
        }
        else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("USER_ID_NOT_EXIST");
            errorModel.setMessage("user does not exist");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);

        }
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> listOfProps = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> propList = new ArrayList<>();
        for(PropertyEntity pe :listOfProps){

            PropertyDTO dto = propertyConverter.propertyEntityToDTO(pe);
            propList.add(dto);

        }

        return propList;
    }

    @Override
    public List<PropertyDTO> getAllPropertiesForUser(Long userId) {
        List<PropertyEntity> listOfProps = (List<PropertyEntity>) propertyRepository.findAllByUserEntityId(userId);
        List<PropertyDTO> propList = new ArrayList<>();
        for(PropertyEntity pe :listOfProps){
            PropertyDTO dto = propertyConverter.propertyEntityToDTO(pe);
            propList.add(dto);

        }

        return propList;

    }

    @Override
    public PropertyDTO propertyUpdate(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optEnt = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEnt.isPresent()){
            PropertyEntity pe = optEnt.get();
            pe.setTitle(propertyDTO.getTitle());
            pe.setAddress(propertyDTO.getAddress());
            pe.setDescription(propertyDTO.getDescription());
            pe.setPrice(propertyDTO.getPrice());
            pe.setOwnerName(propertyDTO.getOwnerName());
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());

            dto = propertyConverter.propertyEntityToDTO(pe);
            propertyRepository.save(pe);

        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEnt = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;

        if(optEnt.isPresent()){

            PropertyEntity pe = optEnt.get();
            pe.setDescription(propertyDTO.getDescription());
            dto = propertyConverter.propertyEntityToDTO(pe);
            propertyRepository.save(pe);
        }

        return dto;

    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optEnt = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;

        if(optEnt.isPresent()){

            PropertyEntity pe = optEnt.get();
            pe.setPrice(propertyDTO.getPrice());
            dto = propertyConverter.propertyEntityToDTO(pe);
            propertyRepository.save(pe);
        }

        return dto;

    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);

    }
}
