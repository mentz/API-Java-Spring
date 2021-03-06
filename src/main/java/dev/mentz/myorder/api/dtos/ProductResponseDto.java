package dev.mentz.myorder.api.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("${product.response}")
public class ProductResponseDto {
    @ApiModelProperty(value = "${product.response.id}")
    private Integer id;

    @ApiModelProperty(value = "${product.response.name}")
    private String name;

    @ApiModelProperty(value = "${product.response.value}")
    private Double value;

    @ApiModelProperty(value = "${product.response.restaurant}")
    private RestaurantResponseDto restaurant;

    public Integer getId() {
        return id;
    }

    public ProductResponseDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductResponseDto setName(String name) {
        this.name = name;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public ProductResponseDto setValue(Double value) {
        this.value = value;
        return this;
    }

    public RestaurantResponseDto getRestaurant() {
        return restaurant;
    }

    public ProductResponseDto setRestaurant(RestaurantResponseDto restaurant) {
        this.restaurant = restaurant;
        return this;
    }
}
