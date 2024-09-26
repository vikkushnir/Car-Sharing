package car.sharing.service.authentication;

import static car.sharing.model.Role.RoleType;

import car.sharing.dto.user.auth.UserRegistrationRequestDto;
import car.sharing.dto.user.auth.UserRegistrationResponseDto;
import car.sharing.exception.RegistrationException;
import car.sharing.mapper.UserMapper;
import car.sharing.model.User;
import car.sharing.repository.RoleRepository;
import car.sharing.repository.UserRepository;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl
        implements RegistrationService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public UserRegistrationResponseDto register(UserRegistrationRequestDto requestDto) {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException("Can't register user with this email: "
                    + requestDto.getEmail() + " is already exists");
        }

        User user = userMapper.toModel(requestDto);
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        user.setRoles(Set.of(
                roleRepository.findByRoleType(RoleType.CUSTOMER)
                        .orElseThrow(() ->
                                new RegistrationException("Can't register user with this role")))
        );
        return userMapper.toDto(userRepository.save(user));
    }
}
