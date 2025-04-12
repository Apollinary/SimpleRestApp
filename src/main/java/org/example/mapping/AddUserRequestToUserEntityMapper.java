package org.example.mapping;

import org.example.dto.User;
import org.example.dto.rest.AddUserRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddUserRequestToUserEntityMapper {
    User map(AddUserRequest source);
}
