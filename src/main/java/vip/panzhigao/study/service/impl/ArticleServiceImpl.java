package vip.panzhigao.study.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import vip.panzhigao.study.entity.Article;
import vip.panzhigao.study.mapper.ArticleMapper;
import vip.panzhigao.study.service.IArticleService;

/**
 * Created by panzhigao on 2019/8/30.
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper,Article> implements IArticleService{
}
