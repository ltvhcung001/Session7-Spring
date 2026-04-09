package org.example.session7.services;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.session7.entities.candidate.Candidate;
import org.example.session7.entities.candidate.dto.CandidateCreateDTO;
import org.example.session7.entities.candidate.dto.CandidateUpdateDTO;
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

    public Candidate update(@Valid CandidateUpdateDTO candidateUpdateDTO, Long id) {
        Candidate candidate = candidatesRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tìm thấy ứng viên có id = " + id));
        candidate.setBio(candidateUpdateDTO.getBio());
        candidate.setAddress(candidateUpdateDTO.getAddress());
        return candidatesRepository.save(candidate);
    }
}
