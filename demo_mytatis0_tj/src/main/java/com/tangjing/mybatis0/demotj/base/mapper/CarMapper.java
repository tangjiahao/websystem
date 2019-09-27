package com.tangjing.mybatis0.demotj.base.mapper;

import com.tangjing.mybatis0.demotj.base.entity.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Mapper
public interface CarMapper {
    @Select("select car_id as carId,name,score from car where car_id = #{id}")
    Car findByCarId(int id);

    List<Car> carList();

    int insertCar(Car car);

    int deleteCar(int id);

    int updateCar(Car car);
}
