package br.edu.ifpb.dac.falacampus.business.service.impl;

import br.edu.ifpb.dac.falacampus.business.service.UserConverterService;
import br.edu.ifpb.dac.falacampus.model.entity.User;
import br.edu.ifpb.dac.falacampus.presentation.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserConverterServiceImpl implements UserConverterService {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDto> userToDTOList(List<User> entities) {
        List<UserDto> dtos = new ArrayList<>();

        for (User dto : entities) {
            UserDto entity = userToDTO(dto);
            dtos.add(entity);
        }
        return dtos;
    }

    @Override
    public User dtoToUser(UserDto dto) {

        User entity = modelMapper.map(dto, User.class);

        return entity;
    }

    @Override
    public UserDto userToDTO(User entity) {

        UserDto dto = modelMapper.map(entity, UserDto.class);

        return dto;
    }

    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
