package vip.panzhigao.study.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.panzhigao.study.entity.Article;
import vip.panzhigao.study.service.IArticleService;

/**
 *
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @GetMapping("{id:^\\d+}")
    public Article getById(@PathVariable("id")Long id){
        return articleService.selectById(id);
    }
}
