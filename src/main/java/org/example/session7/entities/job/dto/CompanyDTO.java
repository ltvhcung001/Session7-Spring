package org.example.session7.entities.job.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CompanyDTO {
    @NotBlank(message = "Tên công ty không được để trống")
    private String name;

    @Size(min = 10, max = 13, message = "Mã số thuế phải từ 10 đến 13 ký tự")
    private String taxCode;
}
