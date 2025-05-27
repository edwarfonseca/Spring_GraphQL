package com.ejemplo.graphql_springboot.graphql;
import com.ejemplo.graphql_springboot.model.Patient;
import com.ejemplo.graphql_springboot.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PatientResolver {

    @Autowired
    private PatientRepository repository;

    @QueryMapping
    public List<Patient> allPatients() {
        return repository.findAll();
    }

    @QueryMapping
    public Patient patientById(@Argument Long id) {
        return repository.findById(id).orElse(null);
    }

    @MutationMapping
    public Patient createPatient(@Argument PatientInput input) {
        Patient p = new Patient();
        p.setName(input.name());
        p.setEmail(input.email());
        return repository.save(p);
    }

    public record PatientInput(String name, String email) {}
}
