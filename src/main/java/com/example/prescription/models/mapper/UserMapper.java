package com.example.prescription.models.mapper;

import com.example.prescription.models.User;
import com.example.prescription.models.dto.RoleEnum;
import com.example.prescription.models.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements BaseMapper<User, UserDto> {
    @Override
    public UserDto convertToDto(User model) {
        return new UserDto(model.getId(),
                model.getFirstName(),
                model.getLastName(),
                model.getEmail(),
                model.getPassword(),
                RoleEnum.valueOf(model.getRole()));
    }

    @Override
    public User convertToModel(UserDto dto) {
        return new User(dto.id(),
                dto.firstName(),
                dto.lastName(),
                dto.email(),
                dto.password(),
                String.valueOf(dto.role()));
    }
}
