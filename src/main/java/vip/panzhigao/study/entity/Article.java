package vip.panzhigao.study.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 文章
 */
@Data
@TableName("t_article")
public class Article implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = -4357328851427096260L;
    /**
     * id
     */
    @TableId("id")
    private Long id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 用户名
     */
    @TableField("username")
    private String username;
    /**
     * 文章状态 0-审核未通过，1-草稿，2-审核中，3-发布成功
     */
    @TableField("status")
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
    @TableField("title")
    private String title;
    /**
     * 文章内容
     */
    @NotEmpty(message="文章内容不能为空")
    //TODO @UnescapeHtml
    @TableField("content")
    private String content;
    /**
     * 文章概要
     */
    @TableField("outline")
    private String outline;
    /**
     * 文章摘要图片
     */
    @TableField("image")
    private String image;
    /**
     * 评论数
     */
    @TableField("comment_count")
    private Integer commentCount;
    /**
     * 阅读次数
     */
    @TableField("view_count")
    private Integer viewCount;
    /**
     * 文章类型
     * 1-文章 2-系统消息
     */
    @TableField("type")
    private Integer type;
    /**
     * 置顶系数,0-未置顶，1-置顶
     */
    @TableField("top")
    private Integer top;
    /**
     * 是否是精品贴,0-否，1-是
     */
    @TableField("high_quality")
    private Integer highQuality;
    /**
     * 分类id
     */
    @TableField("category_id")
    private Long categoryId;


}
