package com.example.demo.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author astupidcoder
 * @since 2020-09-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UserInfo extends Model {

    private static final long serialVersionUID = 1L;

    private Integer uid;

    private String info;

    private Integer sex;

    private String headImage;


}
