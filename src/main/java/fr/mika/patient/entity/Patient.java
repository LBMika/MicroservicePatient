package fr.mika.patient.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Patient {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private Date birthdate;
    private String gender;
    private Long socialNumber;
    private Address address;
    private String nurseId;
}
