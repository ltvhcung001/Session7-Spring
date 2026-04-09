package org.example.session7.entities.job.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JobCreateDTO {
    @NotBlank(message = "Tiêu đề không được để trống")
    private String title;

    @Valid
    @NotNull(message = "Thông tin công ty không được để trống")
    private CompanyDTO company;
}
