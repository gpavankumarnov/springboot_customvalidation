package com.example.customValidator.mapper;
import com.example.customValidator.dto.CreateReferenceDataDto;
import com.example.customValidator.dto.ReferenceDataDto;
import com.example.customValidator.model.ReferenceData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ReferenceDataMapper {


  @Mapping(source="isDeleted", target="deleted")
  List<ReferenceDataDto> convertEntityListToDtoList(List<ReferenceData> referenceDataList);


  @Mapping(source="deleted", target="isDeleted")
  ReferenceData convertReferenceDataDtoToEntity(CreateReferenceDataDto createReferenceDataDto);


  ReferenceDataDto convertReferenceDataEntityToDto(ReferenceData referenceData);



}
