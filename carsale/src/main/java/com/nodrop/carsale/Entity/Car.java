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
@TableName("car")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 车辆编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 车系编号
     */
    private Integer seriesId;

    /**
     * 车辆型号
     */
    private String type;

    /**
     * 车辆颜色
     */
    private String color;

    /**
     * 车辆进价
     */
    private BigDecimal price;

    /**
     * 车辆售价
     */
    private BigDecimal salePrice;

    /**
     * 车辆库存
     */
    private Integer repertory;

    /**
     * 车辆入库时间
     */
    private LocalDateTime createTime;

    /**
     * 车辆状态（0：停售，1：在售，2：停售）
     */
    private String status;


}
