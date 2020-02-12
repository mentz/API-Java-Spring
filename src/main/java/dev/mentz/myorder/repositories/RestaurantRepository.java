package dev.mentz.myorder.repositories;

import dev.mentz.myorder.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositories são interfaces que ligam as entidades aos
// Services.

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    
}
