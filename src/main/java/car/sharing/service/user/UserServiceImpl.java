package car.sharing.service.user;

import car.sharing.dto.user.RoleUpdateRequestDto;
import car.sharing.dto.user.UpdateProfileDto;
import car.sharing.dto.user.UserResponseDto;
import car.sharing.exception.EntityNotFoundException;
import car.sharing.mapper.UserMapper;
import car.sharing.model.User;
import car.sharing.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    @Override
    public void updateRole(Long id, RoleUpdateRequestDto requestDto) {
        User user = getUserById(id);
        user.setRoles(requestDto.getRoles());
        userRepository.save(user);
    }

    @Override
    public UserResponseDto getInfo(String email) {
        User user = getUserByEmail(email);
        return userMapper.toResponseDto(user);
    }

    @Transactional
    @Override
    public UserResponseDto updateProfile(Long id, UpdateProfileDto updateProfileDto) {
        User user = getUserById(id);
        user.setFirstName(updateProfileDto.getFirstName());
        user.setLastName(updateProfileDto.getLastName());
        userRepository.save(user);
        return userMapper.toResponseDto(user);
    }

    private User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can't find User by id: " + id));
    }

    private User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Can't find User by email: " + email));
    }
}
