package dev.mentz.myorder.api.controllers;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("RestaurantControllerV1")
@RequestMapping(RestPath.BASE_PATH + "/restaurant")
// Caracteriza como API para o Swagger e separa em um grupo "Restaurantes"
@Api(tags = "Restaurantes")
public class RestaurantController {

}
