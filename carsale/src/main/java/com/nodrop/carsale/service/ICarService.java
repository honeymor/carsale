package com.nodrop.carsale.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nodrop.carsale.Entity.Car;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-09-17
 */
public interface ICarService extends IService<Car> {
    IPage<Car> selectPage(Page<Car> page, Map<String,Object> paramszz); // 新增分页查询方法
}
