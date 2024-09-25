package com.nodrop.carsale.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nodrop.carsale.Entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-09-17
 */
public interface IUserService extends IService<User> {
    boolean exists(QueryWrapper<User> queryWrapper);
}
