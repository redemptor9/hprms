package com.hprms.repository;

import com.hprms.model.LabTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LabTestRepository extends JpaRepository<LabTest, String> {
    List<LabTest> findByPatientPatientId(String patientId);
}
