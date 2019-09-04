package vip.panzhigao.study.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author panzhigao
 * @since 2019-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long id;
    /**
     * 性别 0-未知，1-男，2-女
     */
    private Integer sex;
    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 最近登陆时间
     */
    @TableField("last_login_time")
    private Date lastLoginTime;
    /**
     * 0-禁用，1-正常
     */
    private Integer status;
    /**
     * 手机号
     */
    private String telephone;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 用户头像
     */
    @TableField("user_portrait")
    private String userPortrait;
    /**
     * 更新人id
     */
    @TableField("update_user")
    private Long updateUser;
    /**
     * 管理员标志，0-否，1-是
     */
    @TableField("admin_flag")
    private Integer adminFlag;
    /**
     * 地址
     */
    private String address;
    /**
     * 用户简介
     */
    @TableField("user_brief")
    private String userBrief;


}
