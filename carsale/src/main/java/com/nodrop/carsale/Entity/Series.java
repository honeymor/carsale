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
@TableName("series")
public class Series implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 车系编号
     */
    @TableId(value = "series_id", type = IdType.AUTO)
    private Integer seriesId;

    /**
     * 品牌编号
     */
    private Integer brandId;

    /**
     * 车系名称
     */
    private String seriesName;

    /**
     * 车系状态（0：删除状态，1：正常状态）
     */
    private String status;


}
