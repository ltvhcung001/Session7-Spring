package org.example.session7.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.session7.dto.ApiResponse;
import org.example.session7.entities.job.Job;
import org.example.session7.entities.job.dto.JobCreateDTO;
import org.example.session7.services.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jobs")
public class JobController {
    private final JobService jobService;

    @PostMapping
    public ResponseEntity<ApiResponse<Job>> createJob(@Valid @RequestBody JobCreateDTO dto) {
        Job newJob = jobService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<Job>builder()
                        .success(true)
                        .message("Tạo tin tuyển dụng thành công!")
                        .data(newJob)
                        .build()
        );
    }
}
