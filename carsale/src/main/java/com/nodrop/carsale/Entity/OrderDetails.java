package com.nodrop.carsale.Entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("order_details")
public class OrderDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单详情编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 订单编号
     */
    private Long orderId;

    /**
     * 车辆编号
     */
    private Long carId;

    /**
     * 车辆订单数
     */
    private Integer carNumber;


}
