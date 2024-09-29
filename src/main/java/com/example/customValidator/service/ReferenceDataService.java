package com.example.customValidator.service;
import com.example.customValidator.dto.CreateReferenceDataDto;
import com.example.customValidator.dto.ReferenceDataDto;
import com.example.customValidator.mapper.ReferenceDataMapper;
import com.example.customValidator.model.ReferenceData;
import com.example.customValidator.repository.ReferenceDataRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class ReferenceDataService {
  private ReferenceDataRepo referenceDataRepo;
  private ReferenceDataMapper referenceDataMapper;

  public ReferenceDataService(ReferenceDataRepo referenceDataRepo, ReferenceDataMapper referenceDataMapper) {
    this.referenceDataRepo = referenceDataRepo;
    this.referenceDataMapper = referenceDataMapper;
  }

  public List<ReferenceDataDto> getAllReferenceData() {
    List<ReferenceData> allReferenceEntity = referenceDataRepo.findAll();
    return referenceDataMapper.convertEntityListToDtoList(allReferenceEntity);
  }

  public Long postReferenceData(CreateReferenceDataDto createReferenceDataDto) {
    ReferenceData referenceData = referenceDataMapper.convertReferenceDataDtoToEntity(createReferenceDataDto);
         referenceDataRepo.save(referenceData);

    return referenceData.getId();

  }

  public ReferenceDataDto getReferenceDataById(Long id) throws Exception {
   Optional<ReferenceData> referenceData = referenceDataRepo.findById(id);
   if(referenceData.isPresent()){
     return referenceDataMapper.convertReferenceDataEntityToDto(referenceData.get());
   }
    throw new Exception("Not Found");

  }



}