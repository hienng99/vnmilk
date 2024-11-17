package com.nvhien.vnmilk.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_ALREADY_EXISTS(1001, "User already exists"),
    USER_PASSWORD_INVALID(1002, "User password must be between 8 to 20 characters"),
    USER_NOT_EXISTS(1003, "User does not exist"),
    UNAUTHENTICATED(1004, "Unauthenticated"),
    INVALID_KEY(9998, "Invalid key"),
    UNKNOWN_EXCEPTION(9999, "Unknown exception"),
    ;
    private final int code;
    private final String message;
}
