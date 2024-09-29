package com.example.customValidator.dto;
import com.example.customValidator.validation.Code;
import lombok.*;
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateReferenceDataDto {

  @Code(maxLength = 6, label = "reference data")
  private String code;

  private String businessName;

  private boolean deleted;


}
