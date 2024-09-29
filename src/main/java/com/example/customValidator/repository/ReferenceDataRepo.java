package com.example.customValidator.repository;
import com.example.customValidator.model.ReferenceData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ReferenceDataRepo extends JpaRepository<ReferenceData, Long> {


  Optional<ReferenceData> findByCode(String code);

}
