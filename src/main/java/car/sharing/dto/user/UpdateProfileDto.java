package car.sharing.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateProfileDto {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
}
