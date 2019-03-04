package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.Candidate;
import com.example.demo.repository.CandidateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService implements ICandidateService {

    @Autowired
    private CandidateRepository candidateRepository;
    
    @Override
    public List<Candidate> getAllCandidates() {
        List<Candidate> list = new ArrayList<>();
		candidateRepository.findAll().forEach(e -> list.add(e));
		return list;
    }

    @Override
    public Candidate getCandidateById(int candidateId) {
        Candidate obj = candidateRepository.findById(candidateId).get();
		return obj;
    }

    @Override
    public boolean addCandidate(Candidate candidate) {
        List<Candidate> list = candidateRepository.findByFirstNameAndLastName(candidate.getFirstName(), candidate.getLastName());
        if (list.size() > 0) {
            return false;
        } else {
            candidateRepository.save(candidate);
        return true;
        }
    }

    @Override
    public void updateCandidate(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    @Override
    public void deleteCandidate(int candidateId) {
        candidateRepository.delete(getCandidateById(candidateId));
    }
}