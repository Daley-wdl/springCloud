package com.dylan.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * User VO
 *
 * @author wudelong
 * @Date 2021/3/29 14:46
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("user")
public class User extends Model<User> {

    private Integer id;

    private String name;
}
