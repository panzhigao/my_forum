package vip.panzhigao.study.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
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
 * 库存表
 * </p>
 *
 * @author panzhigao
 * @since 2019-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_repertory")
public class Repertory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 规格型号
     */
    private String specification;
    /**
     * 单位
     */
    private String unit;
    /**
     * 数量
     */
    private Integer quantity;
    /**
     * 单价
     */
    @TableField("unit_price")
    private BigDecimal unitPrice;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 税额
     */
    private BigDecimal tax;
    /**
     * 总价
     */
    @TableField("total_amount")
    private BigDecimal totalAmount;
    /**
     * 创建人
     */
    @TableField("create_user_id")
    private Long createUserId;
    /**
     *  创建时间
     */
    @TableField("create_time")
    private Date createTime;


}
