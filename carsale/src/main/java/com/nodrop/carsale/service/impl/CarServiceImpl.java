package com.nodrop.carsale.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nodrop.carsale.Entity.Car;
import com.nodrop.carsale.mapper.CarMapper;
import com.nodrop.carsale.service.ICarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-09-17
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements ICarService {
    @Autowired
    private CarMapper carMapper;

    @Override
    public IPage<Car> selectPage(Page<Car> page, Map<String, Object> params) {
        QueryWrapper<Car> queryWrapper = new QueryWrapper<>();

        boolean hasCondition = false; // 标记是否有查询条件

        // 根据 id 进行筛选
        if (params != null && params.containsKey("id")) {
            Object id = params.get("id");
            if (id != null && !id.toString().isEmpty()) {
                queryWrapper.eq("id", id);
                hasCondition = true; // 有查询条件
            }
        }

        // 根据 status 进行筛选
        if (params != null && params.containsKey("status")) {
            Object status = params.get("status");
            if (status != null && !status.toString().isEmpty()) {
                queryWrapper.eq("status", status);
                hasCondition = true; // 有查询条件
            }
        }

        // 如果有查询条件，则带条件分页查询；否则，进行无条件分页查询
        if (hasCondition) {
            return carMapper.selectPage(page, queryWrapper);
        } else {
            return carMapper.selectPage(page, null); // 无条件分页
        }
    }
}