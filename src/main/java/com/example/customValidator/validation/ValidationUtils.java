package com.example.customValidator.validation;
import jakarta.validation.ConstraintValidatorContext;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;
import java.util.AbstractMap;
import java.util.List;

@Slf4j
@NoArgsConstructor
public class ValidationUtils {
  public static boolean addMessageErrorToContext(ConstraintValidatorContext context, String message) {
    //each time you pass single message.
    addMessageErrorToContext(context, List.of(message));
    return false;
  }

  public static boolean addMessageErrorToContext(ConstraintValidatorContext context, List<String> messages) {
// Disable the default violation message
    context.disableDefaultConstraintViolation();

    messages.forEach(m -> context.buildConstraintViolationWithTemplate(m).addConstraintViolation());
    return false;
    //final error looks like this
    //Each message you passed appears -> Invalid email format: invalid-email

  }

  public static AbstractMap.SimpleEntry<Boolean, String> isTooLong(String value, String label, int maxLength) {
    if (value.length() > maxLength) {
      return new AbstractMap.SimpleEntry<>(false, MessageFormat.format("{0} [{1}] is too long, maxLength is {2}", label, value, maxLength));
    }
    return new AbstractMap.SimpleEntry<>(true, StringUtils.EMPTY);
  }


  public static boolean isUpperCaseAlphanumeric(String value){

    if(value == null) return true;
      int size = value.length();

    for (int i = 0; i < size; i++) {
         char c = value.charAt(i);
         if(CharUtils.isAsciiAlphaLower(c)){
           return false;
         }
    }
    return true;
  }


}
