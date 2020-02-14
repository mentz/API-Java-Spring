package dev.mentz.myorder.api.mappers;

import dev.mentz.myorder.api.dtos.CreateProductDto;
import dev.mentz.myorder.api.dtos.ProductResponseDto;
import dev.mentz.myorder.entities.Product;
import org.modelmapper.ModelMapper;

public class ProductMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static Product toEntity(CreateProductDto createProductDto) {
        return modelMapper.map(createProductDto, Product.class);
    }

    public static ProductResponseDto toResponseDto(Product product) {
        return modelMapper.map(product, ProductResponseDto.class);
    }
}
