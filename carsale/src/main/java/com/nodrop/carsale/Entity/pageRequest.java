package com.nodrop.carsale.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class pageRequest {
    private Integer pageNum;
    private Integer pageSize;
    private Map<String, Object> param; // 用于接收额外的参数
}
