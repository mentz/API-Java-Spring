package dev.mentz.myorder.api.mappers;

import dev.mentz.myorder.api.dtos.CreateProductDto;
import dev.mentz.myorder.api.dtos.ProductResponseDto;
import dev.mentz.myorder.entities.Product;
import dev.mentz.myorder.services.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private static RestaurantService restaurantService;

    public static Product toEntity(CreateProductDto createProductDto) {
//        return new modelMapper.map(createProductDto, Product.class);
        Product product = new Product()
                .setName(createProductDto.getName())
                .setValue(createProductDto.getValue())
                .setRestaurant(restaurantService.getEntityById(createProductDto.getRestaurantId()));

        return product;
    }

    public static ProductResponseDto toResponseDto(Product product) {
//        return modelMapper.map(product, ProductResponseDto.class);
        ProductResponseDto productResponseDto = new ProductResponseDto()
                .setRestaurant(RestaurantMapper.toResponseDto(product.getRestaurant()))
                .setName(product.getName())
                .setValue(product.getValue())
                .setId(product.getId());
        return productResponseDto;
    }
}
