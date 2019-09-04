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
 * 用户拓展表
 * </p>
 *
 * @author panzhigao
 * @since 2019-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user_extension")
public class UserExtension implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 用户头像
     */
    @TableField("user_portrait")
    private String userPortrait;
    /**
     * 用户简介
     */
    @TableField("user_brief")
    private String userBrief;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 文章数
     */
    @TableField("article_counts")
    private Integer articleCounts;
    /**
     * 评论数
     */
    @TableField("comment_counts")
    private Integer commentCounts;
    /**
     * 总积分数
     */
    @TableField("total_score")
    private Integer totalScore;
    /**
     * 连续登陆天数
     */
    @TableField("continuous_login_days")
    private Integer continuousLoginDays;
    /**
     * 连续签到天数
     */
    @TableField("continuous_check_in_days")
    private Integer continuousCheckInDays;
    /**
     * 总共登陆天数
     */
    @TableField("total_login_days")
    private Integer totalLoginDays;
    /**
     * 总共签到天数
     */
    @TableField("total_check_in_days")
    private Integer totalCheckInDays;


}
