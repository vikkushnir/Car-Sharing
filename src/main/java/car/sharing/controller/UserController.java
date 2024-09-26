package car.sharing.controller;

import car.sharing.dto.user.RoleUpdateRequestDto;
import car.sharing.dto.user.UpdateProfileDto;
import car.sharing.dto.user.UserResponseDto;
import car.sharing.model.User;
import car.sharing.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PutMapping("/{id}/role")
    @PreAuthorize("hasRole('MANAGER')")
    public void changeRole(@PathVariable Long id, @RequestBody RoleUpdateRequestDto requestDto) {
        userService.updateRole(id, requestDto);
    }

    @GetMapping("/me")
    public UserResponseDto getInfo(@AuthenticationPrincipal User user) {
        return userService.getInfo(user.getEmail());
    }

    @PatchMapping("/me")
    @PreAuthorize("hasRole('CUSTOMER')")
    public UserResponseDto updateProfile(
            @AuthenticationPrincipal User user,
            @RequestBody @Valid UpdateProfileDto updateProfileDto
    ) {
        return userService.updateProfile(user.getId(), updateProfileDto);
    }

}
