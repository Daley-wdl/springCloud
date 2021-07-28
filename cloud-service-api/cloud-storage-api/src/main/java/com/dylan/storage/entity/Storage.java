package com.dylan.storage.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 库存表
 *
 * @author wudelong
 * @Date 2021/6/7 21:01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName
public class Storage extends Model<Storage> {

    private Integer id;

    private String commodityCode;

    private Integer count;

}
