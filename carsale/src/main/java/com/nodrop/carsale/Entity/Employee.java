package com.nodrop.carsale.Entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2024-09-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 员工角色（0：经理，1：销售）
     */
    private String role;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 员工登录密码
     */
    private String password;

    /**
     * 员工身份证号
     */
    private String idCard;

    /**
     * 员工电话号码
     */
    private String phone;

    /**
     * 员工性别：'男'&'女'
     */
    private String gender;

    /**
     * 员工薪资
     */
    private BigDecimal salary;

    /**
     * 员工入职时间
     */
    private LocalDate entryTime;

    /**
     * 员工状态（0：离职，1：在职）
     */
    private String status;


}
