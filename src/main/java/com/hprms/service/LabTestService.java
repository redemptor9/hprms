package com.hprms.service;

import com.hprms.repository.LabTestRepository;
import com.hprms.model.LabTest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabTestService {

    private final LabTestRepository labTestRepository;

    public LabTestService(LabTestRepository labTestRepository) {
        this.labTestRepository = labTestRepository;
    }

    public LabTest addLabTest(LabTest test) {
        labTestRepository.save(test);
        return test;
    }

    public List<LabTest> getPatientLabTests(String patientId) {
        return labTestRepository.findByPatientPatientId(patientId);
    }
    
    public List<LabTest> getAllLabTests() {
        return labTestRepository.findAll();
    }
}
