package com.bct.ficheCarriere.repository.Impl;

import com.bct.ficheCarriere.model.Certificate;
import com.bct.ficheCarriere.model.Training;
import com.bct.ficheCarriere.repository.TrainingAndCertifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TrainingAndCertifRepositoryImpl implements TrainingAndCertifRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Training> getEmployeeTrainings(String employeeId) {
        List<Map<String, Object>> trainingsRows = jdbcTemplate.queryForList("select T.ID,T.TRAININGTYPE,T.TRAININGDESCRIPTION,T.TRAININGBEGINDATE,T.TRAININGENDDATE from grh.FCV_TRAINING T where T.EMPLOYEEID=?",
                employeeId);
        List<Training> trainings = new ArrayList<Training>();
        for (Map<String, Object> trainingRow : trainingsRows) {
            Training training = new Training();
            training.setId(Long.valueOf(String.valueOf(trainingRow.get("id"))));
            training.setTrainingType(String.valueOf(trainingRow.get("TRAININGTYPE")));
            training.setTrainingDescription(String.valueOf(trainingRow.get("TRAININGDESCRIPTION")));
            training.setTrainingBeginDate(String.valueOf(trainingRow.get("TRAININGBEGINDATE")));
            training.setTrainingEndDate(String.valueOf(trainingRow.get("TRAININGENDDATE")));
            trainings.add(training);


        }
        return trainings;
    }

    @Override
    public void postTraining(Training training) {
        jdbcTemplate.update("INSERT INTO FCV_TRAINING(TRAININGTYPE,TRAININGDESCRIPTION,TRAININGBEGINDATE,TRAININGENDDATE,EMPLOYEEID)" +
                " values (?,?,?,?,?)", training.getTrainingType(), training.getTrainingDescription(), training.getTrainingBeginDate(), training.getTrainingEndDate(), training.getEmployeeId());
    }

    @Override
    public void updateTraining(Training training) {
        jdbcTemplate.update("Update FCV_TRAINING set TRAININGTYPE =? , TRAININGDESCRIPTION=?,TRAININGBEGINDATE=?,TRAININGENDDATE=? where id = ?"
                , training.getTrainingType(), training.getTrainingDescription(), training.getTrainingBeginDate(), training.getTrainingEndDate(), training.getId());
    }

    @Override
    public void deleteTraining(Long id) {
        jdbcTemplate.update("delete from FCV_TRAINING where id=?", id);
    }

    @Override
    public List<Certificate> getEmployeeCertificates(String employeeId) {
        List<Map<String, Object>> certificatesRows = jdbcTemplate.queryForList("select C.ID,C.CERTIFTITLE,C.CERTIFDESCRIPTION,C.CERTIFDATE from grh.FCV_CERTIF C where C.EMPLOYEEID=?",
                employeeId);
        List<Certificate> certificates = new ArrayList<>();
        for (Map<String, Object> certificateRow : certificatesRows) {
            Certificate certificate = new Certificate();
            certificate.setCertifTitle(String.valueOf(certificateRow.get("CERTIFTITLE")));
            certificate.setId(Long.valueOf(String.valueOf(certificateRow.get("id"))));
            certificate.setCertifDescription(String.valueOf(certificateRow.get("CERTIFDESCRIPTION")));
            certificate.setCertifDate(String.valueOf(certificateRow.get("CERTIFDATE")));
            certificates.add(certificate);
        }
        return certificates;
    }

    @Override
    public void postCertificate(Certificate certificate) {
        jdbcTemplate.update("INSERT INTO FCV_CERTIF(CERTIFTITLE,CERTIFDESCRIPTION,CERTIFDATE,EMPLOYEEID)" +
                " values (?,?,?,?)", certificate.getCertifTitle(),certificate.getCertifDescription(), certificate.getCertifDate(), certificate.getEmployeeId());
    }

    @Override
    public void updateCertificate(Certificate certificate) {
        jdbcTemplate.update("Update FCV_CERTIF set CERTIFTITLE=? ,CERTIFDESCRIPTION =? , CERTIFDATE=? where id = ?"
                , certificate.getCertifTitle(),certificate.getCertifDescription(), certificate.getCertifDate(), certificate.getId());
    }

    @Override
    public void deleteCertificate(Long id) {
        jdbcTemplate.update("delete from FCV_CERTIF where id=?", id);
    }
}
