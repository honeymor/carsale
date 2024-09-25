package com.nodrop.carsale.service.impl;

import com.nodrop.carsale.Entity.Customer;
import com.nodrop.carsale.mapper.CustomerMapper;
import com.nodrop.carsale.service.ICustomerService;
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
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

}
