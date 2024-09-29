package com.example.customValidator.controller;
import com.example.customValidator.dto.CreateReferenceDataDto;
import com.example.customValidator.dto.ReferenceDataDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api")
public interface ReferenceDataApi {


  @GetMapping
  List<ReferenceDataDto> getAllReferenceData();

@PostMapping
  ReferenceDataDto createReferenceData(@RequestBody @Valid  CreateReferenceDataDto createReferenceDataDto) throws Exception;


}
