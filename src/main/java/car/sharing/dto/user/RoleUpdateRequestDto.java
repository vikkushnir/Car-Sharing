package car.sharing.dto.user;

import car.sharing.model.Role;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class RoleUpdateRequestDto {
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Role> roles;
}
