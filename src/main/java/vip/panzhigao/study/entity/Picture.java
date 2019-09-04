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
 * 图片信息表
 * </p>
 *
 * @author panzhigao
 * @since 2019-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_picture")
public class Picture implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 图片访问路径
     */
    @TableField("picture_url")
    private String pictureUrl;
    /**
     * 图片保存路径
     */
    @TableField("picture_path")
    private String picturePath;


}
