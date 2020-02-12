package dev.mentz.myorder.services;

import dev.mentz.myorder.api.dtos.CreateUserDto;
import dev.mentz.myorder.api.dtos.UserResponseDto;
import dev.mentz.myorder.api.mappers.UserMapper;
import dev.mentz.myorder.entities.User;
import dev.mentz.myorder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserResponseDto create(CreateUserDto createUserDto) {
//        TODO Validar se usuário já existe
        return new UserResponseDto();
    }
}
