package car.sharing.controller;

import car.sharing.dto.car.CarRequestDto;
import car.sharing.dto.car.CarResponseDto;
import car.sharing.service.car.CarService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @PostMapping
    public CarResponseDto saveCar(@RequestBody CarRequestDto requestDto) {
        return carService.save(requestDto);
    }

    @GetMapping
    public List<CarResponseDto> getAll() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public CarResponseDto getById(@PathVariable Long id) {
        return carService.findById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public CarResponseDto updateById(@PathVariable Long id,
                                     @RequestBody @Valid CarRequestDto requestDto) {
        return carService.updateCar(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        carService.deleteById(id);
    }
}
