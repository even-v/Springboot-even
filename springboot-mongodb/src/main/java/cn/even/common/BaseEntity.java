package cn.even.common;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * FileName: BaseEntity
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     6/15/2020 10:38 AM
 * Description:
 */
@Data
public class BaseEntity<M extends Model<?>> extends Model<M> {
    private String id;

}
