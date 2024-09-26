package car.sharing.service.authentication;

import car.sharing.dto.user.auth.UserLoginRequestDto;
import car.sharing.dto.user.auth.UserLoginResponseDto;

public interface AuthenticationService {
    UserLoginResponseDto authenticate(UserLoginRequestDto requestDto);
}
