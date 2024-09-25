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
@TableName("brand")
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 品牌编号
     */
    @TableId(value = "brand_id", type = IdType.AUTO)
    private Integer brandId;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 品牌状态（0：删除状态，1：正常状态）
     */
    private String status;


}
