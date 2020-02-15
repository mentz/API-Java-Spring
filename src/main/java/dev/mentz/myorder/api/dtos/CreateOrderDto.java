package dev.mentz.myorder.api.dtos;


import dev.mentz.myorder.entities.OrderItem;
import dev.mentz.myorder.entities.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel(value = "${order.create}")
public class CreateOrderDto {
    @NotNull
    @ApiModelProperty(value = "${order.create.userId}")
    private Integer userId;

    @NotNull
    @ApiModelProperty(value = "${order.create.restaurantId}")
    private Integer restaurantId;

    @NotEmpty
    @ApiModelProperty(value = "${order.create.orderItemList}")
    private List<CreateOrderItemDto> orderItemList;


    public Integer getUserId() {
        return userId;
    }

    public CreateOrderDto setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public CreateOrderDto setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
        return this;
    }

    public List<CreateOrderItemDto> getOrderItemList() {
        return orderItemList;
    }

    public CreateOrderDto setOrderItemList(List<CreateOrderItemDto> orderItemList) {
        this.orderItemList = orderItemList;
        return this;
    }
}
