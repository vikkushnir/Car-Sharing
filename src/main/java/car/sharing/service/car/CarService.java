package car.sharing.service.car;

import car.sharing.dto.car.CarRequestDto;
import car.sharing.dto.car.CarResponseDto;
import java.util.List;

public interface CarService {
    CarResponseDto save(CarRequestDto carRequestDto);

    List<CarResponseDto> findAll();

    CarResponseDto findById(Long id);

    CarResponseDto updateCar(Long id, CarRequestDto carRequestDto);

    void deleteById(Long id);
}
