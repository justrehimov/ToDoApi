package com.nsp.todo.controller;

import com.nsp.todo.service.impl.UserDetailsServiceImpl;
import com.nsp.todo.model.response.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RestController
@RequestMapping("/register")
public class RegisterController {

    private final UserDetailsServiceImpl userDetailsService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Response register(@RequestPart("user") String user, @RequestPart("cv")MultipartFile multipartFile){
       userDetailsService.register(user,multipartFile);
       return Response.getSuccess();
    }

    @GetMapping("/confirm/{token}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Response confirmUser(@PathVariable("token") String token){
        userDetailsService.confirmUser(token);
        return Response.getSuccess();
    }

}
