package dev.mentz.myorder.services;

import dev.mentz.myorder.api.dtos.CreateProductDto;
import dev.mentz.myorder.api.dtos.CreateUserDto;
import dev.mentz.myorder.api.dtos.ProductResponseDto;
import dev.mentz.myorder.api.dtos.UserResponseDto;
import dev.mentz.myorder.api.mappers.ProductMapper;
import dev.mentz.myorder.api.mappers.RestaurantMapper;
import dev.mentz.myorder.api.mappers.UserMapper;
import dev.mentz.myorder.entities.Product;
import dev.mentz.myorder.entities.Restaurant;
import dev.mentz.myorder.entities.User;
import dev.mentz.myorder.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RestaurantService restaurantService;

    public ProductResponseDto create(CreateProductDto createProductDto) {
        Restaurant restaurant = restaurantService.getEntityById(createProductDto.getRestaurantId());

//        Product product = ProductMapper.toEntity(createProductDto).setRestaurant(restaurant);
        Product product = productRepository.save(new Product()
                .setRestaurant(restaurant)
                .setValue(createProductDto.getValue())
                .setName(createProductDto.getName()));

        return ProductMapper.toResponseDto(product)
                .setRestaurant(RestaurantMapper.toResponseDto(restaurant));
    }
}
