package dev.mentz.myorder.services;

import dev.mentz.myorder.api.dtos.CreateUserDto;
import dev.mentz.myorder.api.dtos.UserResponseDto;
import dev.mentz.myorder.api.mappers.UserMapper;
import dev.mentz.myorder.entities.User;
import dev.mentz.myorder.exceptions.AlreadyExistsException;
import dev.mentz.myorder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserResponseDto create(CreateUserDto createUserDto) {
        validateUserEmail(createUserDto.getEmail());

        User user = userRepository.save(createUser(createUserDto));

        return UserMapper.toResponseDto(user);
    }

    private void validateUserEmail(String email) {
        User user = userRepository.findByEmail(email);

        if (user != null) {
            throw new AlreadyExistsException("Já existe um usuário cadastrado com esse e-mail.");
        }
    }

    private User createUser(CreateUserDto createUserDto) {
        return new User()
                .setName(createUserDto.getName())
                .setEmail(createUserDto.getEmail())
                .setAddress(createUserDto.getAddress())
                .setPassword(createUserDto.getPassword())
                .setPhone(createUserDto.getPhone());
    }

    public UserResponseDto getById(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
        return UserMapper.toResponseDto(user);
    }
}
