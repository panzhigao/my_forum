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
 * 文章分类表
 * </p>
 *
 * @author panzhigao
 * @since 2019-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_article_category")
public class ArticleCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 分类名称
     */
    @TableField("category_name")
    private String categoryName;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 状态，0-首页不展示，1-首页展示
     */
    private Integer status;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 创建人id
     */
    @TableField("create_user_id")
    private Long createUserId;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 更新人id
     */
    @TableField("update_user_id")
    private Long updateUserId;


}
