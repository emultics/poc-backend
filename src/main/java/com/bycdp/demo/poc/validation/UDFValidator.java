package com.bycdp.demo.poc.validation;

import com.bycdp.demo.poc.model.CreateRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UDFValidator implements ConstraintValidator<ValidDimensions, CreateRequest> {

    @Override
    public void initialize(ValidDimensions constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CreateRequest createRequest, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValidVal = true;
        if(createRequest.getDimensions().getItem().getRef_member().equals(createRequest.getDimensions().getItem().getTarget_member())){
            isValidVal = false;
            constraintValidatorContext.buildConstraintViolationWithTemplate("Item ref_member and target_ember should not same")
                    .addPropertyNode("dimensions.item")
                    .addConstraintViolation();

        }

        if(createRequest.getDimensions().getItem().getQuantity()<1){
            isValidVal = false;
            constraintValidatorContext.buildConstraintViolationWithTemplate("Quantity should not be less than 1")
                    .addPropertyNode("dimensions.item.quantity")
                    .addConstraintViolation();
        }

        return isValidVal;

    }
}
