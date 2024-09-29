package com.example.customValidator.controller;
import com.example.customValidator.dto.CreateReferenceDataDto;
import com.example.customValidator.dto.ReferenceDataDto;
import com.example.customValidator.service.ReferenceDataService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ReferenceDataController implements ReferenceDataApi {


  public ReferenceDataService referenceDataService;

  public ReferenceDataController(ReferenceDataService referenceDataService){
    this.referenceDataService = referenceDataService;
  }

  @Override
  @ApiResponse(responseCode = "200", description = "OK")
  @ApiResponse(responseCode = "400", description = "Not found")
  public List<ReferenceDataDto> getAllReferenceData(){
return referenceDataService.getAllReferenceData();
  }


  @Override
  @ResponseStatus(HttpStatus.CREATED)
  @ApiResponse(responseCode = "400", description = "Validation failed")
  public ReferenceDataDto createReferenceData(@RequestBody @Valid CreateReferenceDataDto createReferenceDataDto) throws Exception {
Long refDataId =   referenceDataService.postReferenceData(createReferenceDataDto);

return referenceDataService.getReferenceDataById(refDataId);
  }


}
