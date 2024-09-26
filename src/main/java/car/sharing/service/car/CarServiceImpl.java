package car.sharing.service.car;

import car.sharing.dto.CarRequestDto;
import car.sharing.dto.CarResponseDto;
import car.sharing.exception.EntityNotFoundException;
import car.sharing.mapper.CarMapper;
import car.sharing.model.Car;
import car.sharing.repository.CarRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public CarResponseDto save(CarRequestDto carRequestDto) {
        Car car = carMapper.toModel(carRequestDto);
        return carMapper.toDto(carRepository.save(car));
    }

    @Override
    public List<CarResponseDto> findAll() {
        return carRepository.findAll().stream()
                .map(carMapper::toDto)
                .toList();
    }

    @Override
    public CarResponseDto findById(Long id) {
        return carMapper.toDto(getCarById(id));
    }

    @Transactional
    @Override
    public CarResponseDto updateCar(Long id, CarRequestDto carRequestDto) {
        getCarById(id);

        Car car = carMapper.toModel(carRequestDto);
        car.setId(id);
        return carMapper.toDto(carRepository.save(car));

    }

    @Override
    public void deleteById(Long id) {
        getCarById(id);
        carRepository.deleteById(id);
    }

    private Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can't find car by id: " + id));
    }
}
