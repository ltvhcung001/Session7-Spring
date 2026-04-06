package org.example.session7.services;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.session7.entities.candidate.Candidate;
import org.example.session7.entities.candidate.dto.CandidateCreateDTO;
import org.example.session7.repositories.CandidatesRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidatesService {
    private final CandidatesRepository candidatesRepository;


    public Candidate save(@Valid CandidateCreateDTO dto) {
        Candidate newCandidate = Candidate.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .age(dto.getAge())
                .yearOfExperience(dto.getYearOfExperience())
                .build();
        return candidatesRepository.save(newCandidate);
    }
}
