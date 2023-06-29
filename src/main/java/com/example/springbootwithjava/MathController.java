package com.example.springbootwithjava;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new Exception();
        
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private boolean isNumeric(String numberAsString) {
        return (numberAsString != null) && numberAsString.matches("[-+]?(\\d+)((.|,)\\d+)?");
    }

    private Double convertToDouble(String numberAsString) {
        String fixedNumber = numberAsString.replaceAll(",", ".");
        return Double.parseDouble(fixedNumber);
    }
}
