package org.example.session7.entities.job.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
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

    @NotNull(message = "Lương tối thiểu không được để trống")
    @Min(value = 0, message = "Lương tối thiểu phải >= 0")
    private Long salaryMin;

    @NotNull(message = "Lương tối đa không được để trống")
    @Min(value = 0, message = "Lương tối đa phải >= 0")
    private Long salaryMax;
}
