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
public class ReferenceDataDto {

  private Long id;

  @Code(maxLength = 6, label = "referenceData")
  private String code;

  private String businessName;

  private boolean deleted;

}
