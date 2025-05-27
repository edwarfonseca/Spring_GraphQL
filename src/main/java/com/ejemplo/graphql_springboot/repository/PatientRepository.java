package com.ejemplo.graphql_springboot.repository;
import com.ejemplo.graphql_springboot.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
