package dev.mentz.myorder.api.controllers;

import dev.mentz.myorder.api.RestPath;
import dev.mentz.myorder.api.dtos.CreateProductDto;
import dev.mentz.myorder.api.dtos.ProductResponseDto;
import dev.mentz.myorder.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("ProductControllerV1")
@RequestMapping(RestPath.BASE_PATH + "/product")
@Api(tags = "Produtos")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    @ApiResponses({
            @ApiResponse(code = 201, message = "Produto criado!", response = ProductResponseDto.class)
    })
    public ProductResponseDto create(@RequestBody @Valid CreateProductDto createProductDto) {
        return productService.create(createProductDto);
    }

}
