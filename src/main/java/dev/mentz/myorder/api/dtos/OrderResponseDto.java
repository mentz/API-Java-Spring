package dev.mentz.myorder.api.dtos;

import dev.mentz.myorder.entities.OrderItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "${order.response}")
public class OrderResponseDto {
    @ApiModelProperty(value = "${order.response.id}")
    private Integer id;

    @ApiModelProperty(value = "${order.response.totalValue}")
    private Double totalValue;

    @ApiModelProperty(value = "${order.response.status}")
    private String status;

    @ApiModelProperty(value = "${order.response.user}")
    private UserResponseDto user;

    @ApiModelProperty(value = "${order.response.items}")
    private List<OrderItemResponseDto> items;


    public Integer getId() {
        return id;
    }

    public OrderResponseDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public OrderResponseDto setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public OrderResponseDto setStatus(String status) {
        this.status = status;
        return this;
    }

    public UserResponseDto getUser() {
        return user;
    }

    public OrderResponseDto setUser(UserResponseDto user) {
        this.user = user;
        return this;
    }

    public List<OrderItemResponseDto> getItems() {
        return items;
    }

    public OrderResponseDto setItems(List<OrderItemResponseDto> items) {
        this.items = items;
        return this;
    }
}
