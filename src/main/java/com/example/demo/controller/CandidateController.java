package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.Candidate;
import com.example.demo.service.ICandidateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("ngage")
public class CandidateController {
    @Autowired
    private ICandidateService candidateService;

    @GetMapping("candidate/{id}")
	public ResponseEntity<Candidate> getCandidateById(@PathVariable("id") Integer id) {
		Candidate candidate = candidateService.getCandidateById(id);
		return new ResponseEntity<Candidate>(candidate, HttpStatus.OK);
	}
	@GetMapping("candidates")
	public ResponseEntity<List<Candidate>> getAllCandidates() {
		List<Candidate> list = candidateService.getAllCandidates();
		return new ResponseEntity<List<Candidate>>(list, HttpStatus.OK);
	}
	@PostMapping("candidate")
	public ResponseEntity<Void> addCandidate(@RequestBody Candidate candidate, UriComponentsBuilder builder) {
        boolean flag = candidateService.addCandidate(candidate);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/candidate/{id}").buildAndExpand(candidate.getCandidateId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("candidate")
	public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate candidate) {
		candidateService.updateCandidate(candidate);
		return new ResponseEntity<Candidate>(candidate, HttpStatus.OK);
	}
	@DeleteMapping("candidate/{id}")
	public ResponseEntity<Void> deleteCandidate(@PathVariable("id") Integer id) {
		candidateService.deleteCandidate(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}