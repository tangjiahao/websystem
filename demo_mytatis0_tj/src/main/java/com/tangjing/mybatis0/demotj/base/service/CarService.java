package com.tangjing.mybatis0.demotj.base.service;

import com.tangjing.mybatis0.demotj.base.entity.Car;
import com.tangjing.mybatis0.demotj.base.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarMapper carMapper;
    public  Car findCar(int id){
        return carMapper.findByCarId(id);
    }

    public List<Car> findAll() {
        return carMapper.carList();
    }

    public int insertCar(Car car) {
        return carMapper.insertCar(car);
    }

    public int deleteCar(int id) {
        return carMapper.deleteCar(id);

    }

    public int updateCar(Car car) {
        return carMapper.updateCar(car);
    }

}
