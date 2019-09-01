package vip.panzhigao.study.entity;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * 文章
 */
@Data
@TableName("t_article")
public class Article {

    @TableId("id")
    private Long id;


}
