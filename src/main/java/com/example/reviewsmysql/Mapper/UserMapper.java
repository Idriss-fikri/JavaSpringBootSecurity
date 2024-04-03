package com.example.reviewsmysql.Mapper;

import com.example.reviewsmysql.dto.UserDto;
import com.example.reviewsmysql.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto fromEntityToDto(User user) {

        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setEmail(user.getEmail());

        return userDto;
    }


    public User fromDtoToEntity(UserDto userDto) {

        User user = new User();

        user.setId(userDto.getId());
        user.setLastname(userDto.getLastname());
        user.setFirstname(userDto.getFirstname());
        user.setEmail(userDto.getEmail());

        return user;
    }
}
