package com.example.avia.repositories;

import com.example.avia.models.Cars;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarsRepository extends CrudRepository<Cars, Long> {
    List<Cars> findAllByBrand(String brand);
    List<Cars> findAllByModel(String model);
}
