package org.example.session7.entities.candidate.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CandidateUpdateDTO {
    @NotBlank(message = "Địa chỉ không được rỗng")
    private String address;

    @Size(max = 200, message = "Độ dài tối đa của bio là 200 ký tự")
    private String bio;
}
