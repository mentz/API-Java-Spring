package dev.mentz.myorder.repositories;

import dev.mentz.myorder.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//    Fazer Query JPA deve usar nomes de classes, não das tabelas que
//    elas estão guardadas.
    @Query("SELECT u FROM User u " +
            "WHERE u.email = :userEmail")
    public User findByEmail(@Param("userEmail") String email);
}
