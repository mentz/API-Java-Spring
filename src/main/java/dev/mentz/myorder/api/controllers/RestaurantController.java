package dev.mentz.myorder.api.controllers;

import dev.mentz.myorder.api.RestPath;
import dev.mentz.myorder.api.dtos.CreateRestaurantDto;
import dev.mentz.myorder.api.dtos.RestaurantResponseDto;
import dev.mentz.myorder.services.RestaurantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("RestaurantControllerV1")
@RequestMapping(RestPath.BASE_PATH + "/restaurant")
// @Api Caracteriza como API para o Swagger e tags separa em um grupo "Restaurantes"
@Api(tags = "Restaurantes")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(
            @ApiParam(value = "Objeto que descreve o restaurante que será criado.")
            @RequestBody @Valid CreateRestaurantDto createRestaurantDto) {
//         o @Valid faz a validação dos @NotEmpty definidos no CreateRestaurantDto.java
        restaurantService.createRestaurant(createRestaurantDto);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public RestaurantResponseDto get(@RequestParam @Param("id") Integer id) {
//        RequestParam é parte da requisição ao invés de parte do body.
//        É comum usar Parametros em métodos GET, enquanto métodos POST
//        usam o Body para trafegar dados na requisição.
        return restaurantService.getById(id);
    }
}
