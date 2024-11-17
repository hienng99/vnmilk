package com.nvhien.vnmilk.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreateRequest {
    String username;

    @Size(min = 8, max = 20, message = "USER_PASSWORD_INVALID")
    String password;
    String firstname;
    String lastname;
    LocalDate dob;
}
