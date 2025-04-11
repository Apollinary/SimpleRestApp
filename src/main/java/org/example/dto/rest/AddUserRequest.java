package org.example.dto.rest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AddUserRequest {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Min(18)
    private int age;

    @Email
    private String email;

    @Pattern(regexp = "^\\d{11}$")
    private String phoneNumber;
}
