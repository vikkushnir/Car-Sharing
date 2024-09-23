package car.sharing.mapper;

import car.sharing.config.MapperConfig;
import car.sharing.dto.CarRequestDto;
import car.sharing.dto.CarResponseDto;
import car.sharing.model.Car;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface CarMapper {
    CarResponseDto toDto(Car car);

    Car toModel(CarRequestDto requestDto);
}
