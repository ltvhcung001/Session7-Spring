package org.example.session7.entities.candidate.dto;

import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class CandidateCreateDTO {
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 50, message = "Độ dài 5-50 kí tự")
    private String fullName;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotNull(message = "Tuổi không được để trống")
    @Min(value = 18, message = "Tuổi tối thiểu phải là 18")
    private Integer age;

    @NotNull(message = "Số năm kinh nghiệm không được để trống")
    @Min(value = 0, message = "Số năm kinh nghiệm không được âm")
    private Integer yearOfExperience;
}
