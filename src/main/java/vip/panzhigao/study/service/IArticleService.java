package vip.panzhigao.study.service;

import com.baomidou.mybatisplus.service.IService;
import vip.panzhigao.study.entity.Article;

/**
 *
 * @author panzhigao
 * @date 2019/8/30
 */
public interface IArticleService extends IService<Article>{
    Article getAndCheckById(Long id);
}
