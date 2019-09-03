package vip.panzhigao.study.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * <p>
 * 文章表
 * </p>
 *
 * @author panzhigao
 * @since 2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 0-审核未通过，1-草稿，2-审核中，3-发布成功，4-下线
     */
    private Integer status;
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
     * 发布时间
     */
    @TableField("publish_time")
    private Date publishTime;
    /**
     * 文章标题
     */
    @NotEmpty(message="文章标题不能为空")
    @Size(max=100,message="文章最大100个字符")
    private String title;
    /**
     * 文章内容
     */
    @NotEmpty(message="文章内容不能为空")
    private String content;
    /**
     * 文章概要
     */
    private String outline;
    /**
     * 缩略图
     */
    private String image;
    /**
     * 评论数
     */
    @TableField("comment_count")
    private Integer commentCount;
    /**
     * 阅读数
     */
    @TableField("view_count")
    private Integer viewCount;
    /**
     * 1-文章 2系统公告
     */
    private Integer type;
    /**
     * 置顶系数,0-未置顶，1-置顶
     */
    private Integer top;
    /**
     * 是否是精品贴，0-否，1-是
     */
    @TableField("high_quality")
    private Integer highQuality;
    /**
     * 文章分类
     */
    @TableField("category_id")
    private Long categoryId;


}
