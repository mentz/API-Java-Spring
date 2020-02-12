package dev.mentz.myorder.api.dtos;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

public class CreateRestaurantDto {
//    Poderia usar @NotNull mas uma String "" é NotNull.
//    Portanto precisamos do @NotEmpty, que já inclui
//    testes do @NotNull.
    @NotEmpty
    @ApiModelProperty(value = "Nome")
    private String name;

    @NotEmpty
    @ApiModelProperty(value = "Telefone")
    private String phone;

    @NotEmpty
    @ApiModelProperty(value = "Email")
    private String email;

//     Auto-generated Getters and Setters
    public String getName() {
        return name;
    }

    public CreateRestaurantDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CreateRestaurantDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateRestaurantDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
