package org.example.session7.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.session7.dto.ApiResponse;
import org.example.session7.entities.candidate.Candidate;
import org.example.session7.entities.candidate.dto.CandidateCreateDTO;
import org.example.session7.entities.candidate.dto.CandidateUpdateDTO;
import org.example.session7.services.CandidatesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/candidates")
public class CandidateController {
    private final CandidatesService candidatesService;

    @PostMapping
    public ResponseEntity<ApiResponse<Candidate>> getCandidates(@Valid @RequestBody CandidateCreateDTO dto) {
        Candidate newCandidate = candidatesService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<Candidate>builder()
                        .success(true)
                        .message("Tạo mới ứng viên thành công!")
                        .data(newCandidate)
                        .build()
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<Candidate>> updateCandidate(
            @Valid @ModelAttribute CandidateUpdateDTO candidateUpdateDTO,
            @PathVariable Long id
    ){
        Candidate updatedCandidate = candidatesService.update(candidateUpdateDTO, id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        ApiResponse.<Candidate>builder()
                                .success(true)
                                .message("Cập nhật thông tin ứng viên thành công!")
                                .data(updatedCandidate)
                                .build()
                );
    }
}
