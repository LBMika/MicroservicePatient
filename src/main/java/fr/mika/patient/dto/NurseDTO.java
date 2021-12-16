package fr.mika.patient.dto;


import fr.mika.patient.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NurseDTO {
    private String firstname;
    private String lastname;
    private String proPhone;
    private String homePhone;
    private Address address;
}
