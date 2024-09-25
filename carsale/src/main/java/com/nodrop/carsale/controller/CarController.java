package com.nodrop.carsale.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nodrop.carsale.Entity.Car;
import com.nodrop.carsale.Entity.pageRequest;
import com.nodrop.carsale.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2024-09-17
 */
@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private ICarService carService;
    @GetMapping("/list")
    public List<Car> getCars() {
        return carService.list();
    }
    @PostMapping("/save")
    public boolean saveCar(@RequestBody Car car) {
        return carService.saveOrUpdate(car);
    }
    @PostMapping("/page")
    public IPage<Car> selectPage(@RequestBody pageRequest pageRequest) {
        Integer pageNum = pageRequest.getPageNum();
        Integer pageSize = pageRequest.getPageSize();
        Map<String, Object> params = pageRequest.getParam();
        Page<Car> page = new Page<>(pageNum, pageSize);
        return carService.selectPage(page,params);
    }
    // 删除汽车（根据ID）
    @DeleteMapping("/{id}")
    public boolean deleteCar(@PathVariable Long id) {
        return carService.removeById(id);
    }

}
