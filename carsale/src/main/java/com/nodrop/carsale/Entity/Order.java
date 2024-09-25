package com.nodrop.carsale.Entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
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
@TableName("order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 顾客编号
     */
    private Long customerId;

    /**
     * 负责员工编号
     */
    private Integer employeeId;

    /**
     * 订单总金额
     */
    private BigDecimal totalPrice;

    /**
     * 订单状态（0：未支付，1：已支付，2：已取消）
     */
    private String status;

    /**
     * 订单创建时间
     */
    private LocalDateTime createTime;

    /**
     * 订单支付时间
     */
    private LocalDateTime payTime;

    /**
     * 订单更新时间
     */
    private LocalDateTime updateTime;


}
