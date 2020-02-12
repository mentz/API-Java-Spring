package dev.mentz.myorder.services;

import dev.mentz.myorder.api.dtos.CreateRestaurantDto;
import dev.mentz.myorder.api.dtos.RestaurantResponseDto;
import dev.mentz.myorder.entities.Restaurant;
import dev.mentz.myorder.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<Restaurant> optional = restaurantRepository.findById(id);
        Restaurant restaurant = optional.get();
//        optional.orElse(Restaurant objARetornarCasooptionalSejaVazio);

        return new RestaurantResponseDto()
                .setId(restaurant.getId())
                .setName(restaurant.getName())
                .setPhone(restaurant.getPhone())
                .setEmail(restaurant.getEmail());
    }
}
