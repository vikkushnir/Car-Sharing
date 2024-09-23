package car.sharing.service;

import car.sharing.dto.CarRequestDto;
import car.sharing.dto.CarResponseDto;
import java.util.List;

public interface CarService {
    CarResponseDto save(CarRequestDto carRequestDto);

    List<CarResponseDto> findAll();

    CarResponseDto findById(Long id);

    CarResponseDto updateCar(Long id, CarRequestDto carRequestDto);

    void deleteById(Long id);

}
