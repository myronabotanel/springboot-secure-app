package com.example.demo.dto;

import lombok.Builder;
import java.util.List;
import java.time.LocalDate;

@Builder
public record UserDto(  //ce vrem sa afisam. pentru ca nu vom aifsa toate datele userului, pentru protectia datelor 
        String username,
        List<RoleDto> roles,
        String firstName,
        String lastName,
        String emailAddress) {}