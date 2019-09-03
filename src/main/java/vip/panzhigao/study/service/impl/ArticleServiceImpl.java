package vip.panzhigao.study.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.collections.BagUtils;
import org.springframework.stereotype.Service;
import vip.panzhigao.study.entity.Article;
import vip.panzhigao.study.exception.BusinessException;
import vip.panzhigao.study.mapper.ArticleMapper;
import vip.panzhigao.study.service.IArticleService;

/**
 *
 * @author panzhigao
 * @date 2019/8/30
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper,Article> implements IArticleService{

    @Override
    public Article getAndCheckById(Long id) {
        Article article = super.selectById(id);
        if(article==null){
            throw new BusinessException("根据id未查询到文章信息");
        }
        return article;
    }
}
