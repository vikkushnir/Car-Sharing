package car.sharing.mapper;

import car.sharing.config.MapperConfig;
import car.sharing.dto.user.UserResponseDto;
import car.sharing.dto.user.auth.UserRegistrationRequestDto;
import car.sharing.dto.user.auth.UserRegistrationResponseDto;
import car.sharing.model.Role;
import car.sharing.model.User;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserRegistrationResponseDto toDto(User user);

    UserResponseDto toResponseDto(User user);

    default Set<Role.RoleType> map(Set<Role> roles) {
        return roles.stream()
                .map(Role::getRoleType)
                .collect(Collectors.toSet());
    }

    User toModel(UserRegistrationRequestDto requestDto);
}
