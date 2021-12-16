package fr.mika.patient.service;


import fr.mika.patient.dto.NurseDTO;
import fr.mika.patient.dto.PatientDTO;
import fr.mika.patient.entity.Patient;
import fr.mika.patient.repository.PatientRepository;
import fr.mika.patient.repository.WebNurseRepository;
import org.modelmapper.ModelMapper;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public class PatientService {
    private ModelMapper mapper;
    private PatientRepository repository;
    private WebNurseRepository nurseRepository;

    public PatientService(PatientRepository repository, WebNurseRepository nurseRepository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.nurseRepository = nurseRepository;
    }

    public List<Patient> findAll() {
        return this.repository.findAll();
    }

    /*
    public Mono<PatientDTO> findById(String id) {

        this.nurseRepository.getNurseById(patient.getNurseId())


        Mono<PatientDTO> result = Mono.just(this.repository.findById(id))
                .map(opt -> {
                    Patient patient = opt.orElse(null);
                    PatientDTO patientDTO = this.mapper.map(patient, PatientDTO.class);
                })



        Patient patient = this.repository.findById(id).orElse(null);
        PatientDTO patientDTO;
        if (patient!=null) {
            Mono<NurseDTO> nurse = this.nurseRepository.getNurseById(patient.getNurseId());
            patientDTO = this.mapper.map(patient, PatientDTO.class);
            patientDTO.getNurse(this.mapper.map(, NurseDTO.class));
        }
        else
            patientDTO = null;


        return patientDTO;
    }
    */

    public PatientDTO findOne(String id) {
        //Recuperation du patient
        Optional<Patient> patient = this.repository.findById(id);
        //recuperation de l'id de l'infirmier
        //On le met a null si on ne recupere rien
        PatientDTO patientDTO= null;
        if (patient.isPresent()) {
            patientDTO = this.mapper.map(patient.get(), PatientDTO.class);

            //mappage de  l'optionnal en patient (avec le .get().get...)
            String nurseId= patient.get().getNurseId();
            //Call du microservice infirmier
            Mono<NurseDTO> infirmier = this.nurseRepository.getNurseById(nurseId);

            //fusion des datas
            //On creer un patientavecInfosInfirmier ou on met infirmier et le patient mappés.
            patientDTO.setNurse(infirmier.block());
        }
        return patientDTO;
    }

    public List<Patient> findAllByNurseId(String id) {
        return this.repository.findAllByNurseId(id);
    }

    public Patient save(Patient patient) {
        return this.repository.save(patient);
    }

    public Patient update(Patient patient) {
        return this.repository.save(patient);
    }

    public void deleteById(String id) {
        this.repository.deleteById(id);
    }
}
