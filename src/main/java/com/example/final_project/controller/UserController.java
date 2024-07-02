package com.example.final_project.controller;

import com.example.final_project.dto.requestDto.UserLoginRequestDto;
import com.example.final_project.dto.requestDto.UserRegisterRequestDto;
import com.example.final_project.dto.requestDto.UserUpdateRequestDto;
import com.example.final_project.dto.responsedDto.UserResponseDto;
import com.example.final_project.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
@Tag(name = "User controller.", description = "User registration is carried out using this controller.")
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "User registration.",
            description = "Allows you to register a new user."
    )
    public UserResponseDto registerUserProfile(@RequestBody UserRegisterRequestDto userRequestDto) {
        return userService.registerUserProfile(userRequestDto);
    }

    @PostMapping(value = "/login")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "User login.",
            description = "Allows a user to log in by providing email and password."
    )
    public UserResponseDto loginUserProfile(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        return userService.loginUserProfile(userLoginRequestDto);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "User update.",
            description = "Allows the user to update their data."
    )
    public UserResponseDto updateUserProfile(@RequestBody UserUpdateRequestDto userUpdateRequestDto,
                                             @PathVariable @Valid @Min(1) Long id) {
        return userService.updateUserProfile(userUpdateRequestDto, id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Deletes the user.",
            description = "Allows you to delete a user profile."
    )
    public void deleteUserProfileById(@PathVariable @Valid @Min(1) Long id) {
        userService.deleteUserProfileById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Finds all users.",
            description = "Allows you to find all registered users."
    )
    public List<UserResponseDto> getAllUsersProfiles() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Finds the user.",
            description = "Allows you to find one of the registered users by using the id."
    )
    public UserResponseDto getUserProfileById(@PathVariable @Valid @Min(1) Long id) {
        return userService.getUserById(id);
    }
}
