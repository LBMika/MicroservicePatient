package fr.mika.patient.dto;

import fr.mika.patient.dto.NurseDTO;
import fr.mika.patient.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Mono;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientDTO {
    private String firstname;
    private String lastname;
    private Date birthdate;
    private String gender;
    private Long socialNumber;
    private Address address;
    private NurseDTO nurse;
}
