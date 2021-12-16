package fr.mika.patient.repository;

import fr.mika.patient.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PatientRepository extends MongoRepository<Patient, String> {
    List<Patient> findAllByNurseId(String id);
}
