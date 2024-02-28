package com.bct.ficheCarriere.repository;
import com.bct.ficheCarriere.model.Certificate;
import com.bct.ficheCarriere.model.Training;


import java.util.List;

public interface TrainingAndCertifRepository {
    List<Training> getEmployeeTrainings(String employeeId);


    void postTraining(Training training);

    void updateTraining(Training training);

    void deleteTraining(Long id);

    List<Certificate> getEmployeeCertificates(String employeeId);


    void postCertificate(Certificate certificate);

    void updateCertificate(Certificate certificate);

    void deleteCertificate(Long id);



}
