package com.example.demo.repository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.example.demo.entity.Candidate;

public interface CandidateRepository extends CrudRepository<Candidate, Integer>{
    List<Candidate> findByFirstNameAndLastName(String firstName, String lastName);
}