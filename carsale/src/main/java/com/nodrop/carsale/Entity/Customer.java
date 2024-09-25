package com.nodrop.carsale.Entity;

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
@TableName("customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 顾客编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 顾客姓名
     */
    private String name;

    /**
     * 顾客电话
     */
    private String phone;

    /**
     * 顾客身份证号
     */
    private String idCard;

    /**
     * 顾客信息创建时间
     */
    private LocalDateTime createTime;


}
