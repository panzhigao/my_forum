package vip.panzhigao.study.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.panzhigao.study.entity.Article;
import vip.panzhigao.study.service.IArticleService;
import vip.panzhigao.study.vo.Response;

/**
 *
 * @author panzhigao
 */
@RestController
@RequestMapping("article")
@Slf4j
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @GetMapping("{id:^\\d+}")
    public Response<Article> getById(@PathVariable("id")Long id){
        log.info("查询文章信息,id={}",id);
        Article article = articleService.getAndCheckById(id);
        return Response.success(article,"查询文章信息成功");
    }
}
