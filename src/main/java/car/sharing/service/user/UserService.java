package car.sharing.service.user;

import car.sharing.dto.user.RoleUpdateRequestDto;
import car.sharing.dto.user.UpdateProfileDto;
import car.sharing.dto.user.UserResponseDto;

public interface UserService {
    void updateRole(Long id, RoleUpdateRequestDto requestDto);

    UserResponseDto getInfo(String email);

    UserResponseDto updateProfile(Long id, UpdateProfileDto updateProfileDto);
}
