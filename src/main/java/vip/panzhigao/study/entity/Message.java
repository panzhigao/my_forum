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
 * 消息通知表
 * </p>
 *
 * @author panzhigao
 * @since 2019-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_message")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 0-未读 1-已读
     */
    private Integer status;
    /**
     * 接收者id
     */
    @TableField("receiver_user_id")
    private Long receiverUserId;
    /**
     * 发送者姓名
     */
    @TableField("sender_name")
    private String senderName;
    /**
     * 发送消息者id
     */
    @TableField("sender_user_id")
    private Long senderUserId;
    /**
     * 消息类别 1-评论 2-系统消息 3-公告
     */
    @TableField("message_type")
    private Integer messageType;
    /**
     * 内容id
     */
    @TableField("article_id")
    private Long articleId;
    /**
     * 评论id
     */
    @TableField("comment_id")
    private Long commentId;
    /**
     * 内容名称
     */
    @TableField("content_name")
    private String contentName;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 评论内容
     */
    @TableField("comment_content")
    private String commentContent;


}
