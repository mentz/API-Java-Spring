package dev.mentz.myorder.api.controllers;

import dev.mentz.myorder.api.RestPath;
import dev.mentz.myorder.api.dtos.CreateRestaurantDto;
import dev.mentz.myorder.api.dtos.CreateUserDto;
import dev.mentz.myorder.api.dtos.RestaurantResponseDto;
import dev.mentz.myorder.api.dtos.UserResponseDto;
import dev.mentz.myorder.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;

@RestController("UserController")
@RequestMapping(RestPath.BASE_PATH + "/user")
@Api(tags = "Usuários")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDto create(
            @ApiParam(value = "Objeto que contém informações do usuário que será criado.")
            @RequestBody @Valid CreateUserDto createUserDto) {
        return userService.create(createUserDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDto getById(
            @ApiParam(value = "Identificador do usuário a buscar.")
            @RequestParam @Param("id") Integer id) {
        return userService.getById(id);
    }
}
