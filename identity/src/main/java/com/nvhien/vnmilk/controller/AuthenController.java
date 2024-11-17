package com.nvhien.vnmilk.controller;

import com.nvhien.vnmilk.dto.request.AuthenRequest;
import com.nvhien.vnmilk.dto.request.IntrospectRequest;
import com.nvhien.vnmilk.dto.response.ApiResponse;
import com.nvhien.vnmilk.dto.response.AuthenResponse;
import com.nvhien.vnmilk.dto.response.IntrospectResponse;
import com.nvhien.vnmilk.service.AuthenService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenController {
    AuthenService authenService;

    @PostMapping("/token")
    ApiResponse<AuthenResponse> authenticate(@RequestBody AuthenRequest authenRequest) {
        AuthenResponse authenResponse = authenService.authenticate(authenRequest);

        return ApiResponse.<AuthenResponse>builder().data(authenResponse).build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> validateToken(@RequestBody IntrospectRequest introspectRequest) {
        IntrospectResponse response = authenService.introspect(introspectRequest);

        return ApiResponse.<IntrospectResponse>builder().data(response).build();
    }
}
