package dev.mentz.myorder.api.mappers;

import dev.mentz.myorder.api.dtos.CreateRestaurantDto;
import dev.mentz.myorder.api.dtos.RestaurantResponseDto;
import dev.mentz.myorder.entities.Restaurant;
import org.modelmapper.ModelMapper;

public class RestaurantMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static Restaurant toEntity(CreateRestaurantDto createRestaurantDto) {
        return modelMapper.map(createRestaurantDto, Restaurant.class);
    }

    public static RestaurantResponseDto toResponseDto(Restaurant restaurant) {
        return modelMapper.map(restaurant, RestaurantResponseDto.class);
    }
}
