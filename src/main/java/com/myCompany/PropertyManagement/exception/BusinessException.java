package com.myCompany.PropertyManagement.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BusinessException extends RuntimeException{

    List<ErrorModel> errors;

    public BusinessException(List<ErrorModel> errors){
        this.errors = errors;

    }

}
