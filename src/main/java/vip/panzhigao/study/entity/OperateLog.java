package vip.panzhigao.study.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 操作日志表
 * </p>
 *
 * @author panzhigao
 * @since 2019-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_operate_log")
public class OperateLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 操作内容
     */
    private String content;
    /**
     * 操作类型
     */
    @TableField("operate_type")
    private Integer operateType;
    /**
     * ip
     */
    private Integer ip;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;


}
