package dev.mentz.myorder.api.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "${orderItem.response}")
public class OrderItemResponseDto {
    @ApiModelProperty(value = "${orderItem.response.id}")
    private Integer id;

    @ApiModelProperty(value = "${orderItem.response.quantity}")
    private Integer quantity;

    @ApiModelProperty(value = "${orderItem.response.product}")
    private ProductResponseDto product;


    public Integer getId() {
        return id;
    }

    public OrderItemResponseDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderItemResponseDto setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public ProductResponseDto getProduct() {
        return product;
    }

    public OrderItemResponseDto setProduct(ProductResponseDto product) {
        this.product = product;
        return this;
    }
}
