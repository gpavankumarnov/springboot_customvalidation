package com.example.customValidator.validation;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;
import java.util.AbstractMap;
@Slf4j
public class CodeValidator implements ConstraintValidator<Code, String> {
  private int maxLength;
  //To show some defined error message labels.
  private String label;
  //field is required or not
  private boolean required;

  private String message;

  @Override
  public void initialize(Code constrainAnnotation) {
    this.label = constrainAnnotation.label();
    this.maxLength = constrainAnnotation.maxLength();
    this.required = constrainAnnotation.required();
    this.message = constrainAnnotation.message();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    log.debug("Validation of label {} of type code with value [{}]", label, value);

    if (StringUtils.isBlank(value)) {
      //by default required is true so if you explicity pass it as false then here we ignore
      if (required) {
        return ValidationUtils.addMessageErrorToContext(context, MessageFormat.format("{0} value must not be blank or null", value));
      }
      return true;
    }

    AbstractMap.SimpleEntry<Boolean, String> isTooLong = ValidationUtils.isTooLong(value, label, maxLength);
    if (Boolean.FALSE.equals(isTooLong.getKey())) {
      return ValidationUtils.addMessageErrorToContext(context, isTooLong.getValue());
    }

//    if (ValidationUtils.isUpperCaseAlphanumeric(value)) {
//      return ValidationUtils.addMessageErrorToContext(context, MessageFormat.format("{0}: value [{1}] must be uppercase", label, value));
//    }

    return true;
  }
}
