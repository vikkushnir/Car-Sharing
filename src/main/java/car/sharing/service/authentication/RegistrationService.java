package car.sharing.service.authentication;

import car.sharing.dto.user.auth.UserRegistrationRequestDto;
import car.sharing.dto.user.auth.UserRegistrationResponseDto;

public interface RegistrationService {
    UserRegistrationResponseDto register(UserRegistrationRequestDto requestDto);
}
