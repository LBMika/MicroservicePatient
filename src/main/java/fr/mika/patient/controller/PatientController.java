package fr.mika.patient.controller;

import com.fasterxml.jackson.databind.JsonNode;
import fr.mika.patient.dto.PatientDTO;
import fr.mika.patient.entity.Patient;
import fr.mika.patient.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@RestController
@CrossOrigin
@RequestMapping("/patients")
public class PatientController {
    private ModelMapper mapper;
    private PatientService service;

    public PatientController(PatientService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<Patient> findAll() {
        return this.service.findAll();
    }

    /*
    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> findById(@PathVariable String id) {
        ResponseEntity result;
        PatientDTO patientDTO = this.service.findById(id);
        if (patientDTO==null)
            result = ResponseEntity.notFound().build();
        else {
            result = ResponseEntity.ok(patientDTO);

        }
        return result;
    }
    */
    @GetMapping("/{id}")
    public PatientDTO findById(@PathVariable String id) {
        return this.service.findOne(id);
    }

    @GetMapping("/nurse/{id}")
    public List<Patient> findAllByNurseId(@PathVariable String id) {
        return this.service.findAllByNurseId(id);
    }

    @PostMapping
    public ResponseEntity<Patient> save(@RequestBody Patient patient) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(patient));
    }

    @PutMapping
    public ResponseEntity<Patient> updateById(@RequestBody Patient patient) {
        return ResponseEntity.ok(this.service.update(patient));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(@RequestBody Patient patient) {
        this.service.deleteById(patient.getId());
        return ResponseEntity.ok(true);
    }
}
