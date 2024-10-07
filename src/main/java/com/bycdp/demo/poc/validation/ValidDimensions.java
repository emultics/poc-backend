package com.bycdp.demo.poc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Constraint(validatedBy = UDFValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDimensions {
    String message() default "ref_member and target_member must not be equal in Product/Item";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}