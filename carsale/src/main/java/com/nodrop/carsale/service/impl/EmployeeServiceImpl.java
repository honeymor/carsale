package com.nodrop.carsale.service.impl;

import com.nodrop.carsale.Entity.Employee;
import com.nodrop.carsale.mapper.EmployeeMapper;
import com.nodrop.carsale.service.IEmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
