package com.myCompany.PropertyManagement.controller;

import com.myCompany.PropertyManagement.dto.CalcuatorDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {
    //http://localhost:8080/api/v1/calculator/add?num1=6.7&num2=1.3
    @GetMapping("/add")
    public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2){
        return num1+num2;
    }
    @GetMapping("/sub/{num1}/{num2}")
    public Double substract(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2){
        Double result = null;

        if (num1>num2){
            result = num1-num2;
        }
        else{
            result = num2-num1;
        }
        return result;
    }

    @PostMapping("/mul")
    public Double multiply(@RequestBody CalcuatorDTO calcuatorDTO){

        Double result = null;
        result = calcuatorDTO.getNum1() * calcuatorDTO.getNum2() * calcuatorDTO.getNum3() * calcuatorDTO.getNum4();

        return result;
    }


}
