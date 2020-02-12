package dev.mentz.myorder.api.mappers;

import dev.mentz.myorder.api.dtos.CreateRestaurantDto;
import dev.mentz.myorder.api.dtos.CreateUserDto;
import dev.mentz.myorder.api.dtos.UserResponseDto;
import dev.mentz.myorder.entities.User;
import org.modelmapper.ModelMapper;

public class UserMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static User toEntity(CreateUserDto createUserDto) {
        return modelMapper.map(createUserDto, User.class);
    }

    public static UserResponseDto toResponseDto(User user) {
        return modelMapper.map(user, UserResponseDto.class);
    }
}
