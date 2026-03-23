package com.hprms.repository;

import com.hprms.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, String> {
    List<MedicalRecord> findByPatientPatientId(String patientId);
}
