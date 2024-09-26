package car.sharing.controller;

import car.sharing.dto.user.auth.UserLoginRequestDto;
import car.sharing.dto.user.auth.UserLoginResponseDto;
import car.sharing.dto.user.auth.UserRegistrationRequestDto;
import car.sharing.dto.user.auth.UserRegistrationResponseDto;
import car.sharing.exception.RegistrationException;
import car.sharing.service.authentication.AuthenticationService;
import car.sharing.service.authentication.RegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final RegistrationService registrationService;
    private final AuthenticationService authenticationService;

    @PostMapping("/registration")
    public UserRegistrationResponseDto register(
            @RequestBody @Valid UserRegistrationRequestDto requestDto
    ) throws RegistrationException {
        return registrationService.register(requestDto);
    }

    @PostMapping("/login")
    public UserLoginResponseDto login(@RequestBody UserLoginRequestDto requestDto) {
        return authenticationService.authenticate(requestDto);
    }
}
