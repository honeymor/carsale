package com.nodrop.carsale.service.impl;

import com.nodrop.carsale.Entity.Order;
import com.nodrop.carsale.mapper.OrderMapper;
import com.nodrop.carsale.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-09-17
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
