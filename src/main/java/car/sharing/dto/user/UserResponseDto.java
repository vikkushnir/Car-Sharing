package car.sharing.dto.user;

import static car.sharing.model.Role.RoleType;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class UserResponseDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<RoleType> roles = new HashSet<>();
}
