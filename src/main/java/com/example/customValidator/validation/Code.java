package com.example.customValidator.validation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.lang.reflect.Type;
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CodeValidator.class)
public @interface Code {

   String message() default "Invalid Code";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};

int maxLength();

boolean required() default true;

String label();
  


}
