package fr.mika.patient.configuration;

import fr.mika.patient.repository.PatientRepository;
import fr.mika.patient.repository.WebNurseRepository;
import fr.mika.patient.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientConfiguration {
    @Bean
    public PatientService nurseService(PatientRepository repository, WebNurseRepository nurseRepository, ModelMapper mapper) {
        return new PatientService(repository, nurseRepository, mapper);
    }
}
