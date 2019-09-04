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
 * 积分历史表
 * </p>
 *
 * @author panzhigao
 * @since 2019-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_score_history")
public class ScoreHistory implements Serializable {

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
     * 积分类型，1-登陆，2-发表文章成功，3-回帖,4-签到.5-注册
     */
    private Integer type;
    /**
     * 类型名
     */
    @TableField("type_name")
    private String typeName;
    /**
     * 积分
     */
    private Integer score;
    /**
     * 积分获取日期
     */
    @TableField("score_date")
    private Date scoreDate;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 积分总计
     */
    @TableField("total_score")
    private Integer totalScore;


}
