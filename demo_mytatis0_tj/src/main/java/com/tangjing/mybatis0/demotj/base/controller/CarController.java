package com.tangjing.mybatis0.demotj.base.controller;

import com.tangjing.mybatis0.demotj.base.entity.Car;
import com.tangjing.mybatis0.demotj.base.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/MabCrud", method = { RequestMethod.GET, RequestMethod.POST })
public class CarController {
    @Autowired
    CarService carService;

    @RequestMapping("show/{id}")
    public String test(@PathVariable int id){
        return carService.findCar(id).toString();
    }

    @RequestMapping("showAll")
    @ResponseBody
    public List<Car> show(){
        return carService.findAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int id) {
        int result = carService.deleteCar(id);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Car car) {
        int result = carService.updateCar(car);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(Car car) {
        int result = carService.insertCar(car);
        if (result >= 1) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }


}



