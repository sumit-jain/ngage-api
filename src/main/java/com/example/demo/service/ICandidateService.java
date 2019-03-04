package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Candidate;

public interface ICandidateService {
    List<Candidate> getAllCandidates();
    Candidate getCandidateById(int candidateId);
    boolean addCandidate(Candidate candidate);
    void updateCandidate(Candidate candidate);
    void deleteCandidate(int candidateId);
} 