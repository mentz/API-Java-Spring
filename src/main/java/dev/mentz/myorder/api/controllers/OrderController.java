package dev.mentz.myorder.api.controllers;

import dev.mentz.myorder.api.RestPath;
import dev.mentz.myorder.api.dtos.CreateOrderDto;
import dev.mentz.myorder.api.dtos.OrderResponseDto;
import dev.mentz.myorder.services.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController("OrderControllerV1")
@RequestMapping(RestPath.BASE_PATH + "/order")
@Api(tags = "Pedido")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    @ApiResponses({
            @ApiResponse(code = 201, message = "Pedido efetuado!", response = OrderResponseDto.class)
    })
    public OrderResponseDto create(@RequestBody @Valid CreateOrderDto createOrderDto) {
        return orderService.create(createOrderDto);
    }
}
