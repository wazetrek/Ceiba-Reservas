package com.ceiba.ceibahs.utils;

import com.ceiba.ceibahs.utils.exception.MaxCharacterException;
import com.ceiba.ceibahs.utils.exception.NoZeroValueException;
import com.ceiba.ceibahs.utils.exception.ObligatoryFieldException;

public final class FieldValidate {

    private FieldValidate() {
        throw new IllegalStateException("Clase de utilidad");
    }

    public static void validateNotNull(Object object, String errorMessage){
        if(object == null){
            throw new ObligatoryFieldException(errorMessage);
        }
    }

    public static void validateNotZeroValue(Object object, String errorMessage){
        if(object.equals(0)){
            throw new NoZeroValueException(errorMessage);
        }
    }

    public static void maxCharacterValidation(String text, Long len, String errorMessage){
        if(text.length() > len){
            throw new MaxCharacterException(errorMessage);
        }
    }
}
