package org.example.session7.services;

import lombok.RequiredArgsConstructor;
import org.example.session7.entities.job.Job;
import org.example.session7.entities.job.dto.JobCreateDTO;
import org.example.session7.repositories.JobRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;

    public Job save(JobCreateDTO dto) {
        if (dto.getSalaryMin() > dto.getSalaryMax()) {
            throw new IllegalArgumentException("Lương tối thiểu không được lớn hơn lương tối đa");
        }

        Job newJob = Job.builder()
                .title(dto.getTitle())
                .companyName(dto.getCompany().getName())
                .taxCode(dto.getCompany().getTaxCode())
                .salaryMin(dto.getSalaryMin())
                .salaryMax(dto.getSalaryMax())
                .build();
        return jobRepository.save(newJob);
    }
}
