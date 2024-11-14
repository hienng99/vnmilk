package com.nvhien.vnmilk.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserCreateRequest {
    private String username;

    @Size(min = 8, max = 20, message = "USER_PASSWORD_INVALID")
    private String password;
    private String firstname;
    private String lastname;
    private LocalDate dob;
}
