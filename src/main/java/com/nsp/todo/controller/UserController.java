package com.nsp.todo.controller;

import com.nsp.todo.model.dto.UserDto;
import com.nsp.todo.model.response.Response;
import com.nsp.todo.model.response.ResponseModel;
import com.nsp.todo.model.response.UserResponse;
import com.nsp.todo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/list")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseModel<List<UserResponse>> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseModel<UserResponse> getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/logged")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseModel<UserResponse> getLoggedInUser(Authentication auth){
        return userService.getLoggedInUser(auth);
    }

    @GetMapping("/confirm/{token}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Response changeMail(@PathVariable("token") String token){
        userService.changeMail(token);
        return Response.getSuccess();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Response updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto){
        userService.updateUser(userDto,id);
        return Response.getSuccess();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Response deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return Response.getSuccess();
    }
}
