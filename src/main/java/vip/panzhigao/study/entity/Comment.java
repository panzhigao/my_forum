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
 * 评论信息
 * </p>
 *
 * @author panzhigao
 * @since 2019-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;
    /**
     * 评论者id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 文章id
     */
    @TableField("article_id")
    private Long articleId;
    /**
     * 评论内容
     */
    @TableField("comment_content")
    private String commentContent;
    /**
     * 接收评论者的userId
     */
    @TableField("reply_to_user_id")
    private String replyToUserId;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 点赞数
     */
    @TableField("praise_counts")
    private Long praiseCounts;


}
