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
 * 异常信息日志表
 * </p>
 *
 * @author panzhigao
 * @since 2019-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_exception_log")
public class ExceptionLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 远程访问主机IP
     */
    private Integer ip;
    /**
     * 类名
     */
    @TableField("class_name")
    private String className;
    /**
     * 方法名
     */
    @TableField("method_name")
    private String methodName;
    /**
     * 异常类型
     */
    @TableField("exception_type")
    private String exceptionType;
    /**
     * 异常信息
     */
    @TableField("exception_msg")
    private String exceptionMsg;
    /**
     * 是否查看，0：未查看、1：已查看
     */
    @TableField("is_view")
    private Integer isView;
    /**
     * 异常发生时间
     */
    @TableField("create_time")
    private Date createTime;


}
