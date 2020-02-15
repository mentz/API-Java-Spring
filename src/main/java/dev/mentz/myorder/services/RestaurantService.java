package dev.mentz.myorder.services;

import dev.mentz.myorder.api.dtos.CreateRestaurantDto;
import dev.mentz.myorder.api.dtos.RestaurantResponseDto;
import dev.mentz.myorder.api.mappers.RestaurantMapper;
import dev.mentz.myorder.entities.Restaurant;
import dev.mentz.myorder.exceptions.NotFoundException;
import dev.mentz.myorder.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    // Vamos usar um padrão chamado DTO (Data Transfer Object).
    // É um objeto que facilita a movimentação de dados na API.
    public void createRestaurant(CreateRestaurantDto createRestaurantDto) {
//        TODO validações

        Restaurant restaurant = new Restaurant()
                .setName(createRestaurantDto.getName())
                .setPhone(createRestaurantDto.getPhone())
                .setEmail(createRestaurantDto.getEmail());

        restaurantRepository.save(restaurant);
    }

    public RestaurantResponseDto getById(Integer id) {
//        Optional dá possibilidade de receber um objeto vazio e lidar
//        com isso de forma graciosa (sem exceções).
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);

        if (!optionalRestaurant.isPresent()) {
            throw new NotFoundException("Não encontrado restaurante com id: " + id);
        }

        Restaurant restaurant = optionalRestaurant.get();
//        optionalRestaurant.orElse(Restaurant objARetornarCasooptionalSejaVazio);

        return new RestaurantResponseDto()
                .setId(restaurant.getId())
                .setName(restaurant.getName())
                .setPhone(restaurant.getPhone())
                .setEmail(restaurant.getEmail());
    }

    public RestaurantResponseDto getDtoFromEntity(Restaurant restaurant) {
        return RestaurantMapper.toResponseDto(restaurant);
    }

    public Restaurant getEntityById(Integer id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);

        if (!optionalRestaurant.isPresent()) {
            throw new NotFoundException("Não encontrado restaurante com id: " + id);
        }

        return optionalRestaurant.get();
    }

    public List<RestaurantResponseDto> getAll() {
        List<Restaurant> restaurantList = restaurantRepository.findAll();

        return restaurantList.stream().map(RestaurantMapper::toResponseDto).collect(Collectors.toList());
    }
}
