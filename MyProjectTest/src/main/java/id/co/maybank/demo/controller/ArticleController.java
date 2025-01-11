package id.co.maybank.demo.controller;

import id.co.maybank.demo.response.MyResponse;
import id.co.maybank.demo.dto.ArticleDto;
import id.co.maybank.demo.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

/**
 * The type Article controller.
 */
@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {

    ArticleService articleService;

    /**
     * Instantiates a new Article controller.
     *
     * @param articleService the article service
     */
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * Find all response entity.
     *
     * @return the response entity
     */
    @GetMapping("/findall")
    public ResponseEntity<MyResponse> findAll() {
        List<ArticleDto> list = articleService.getAllArticles();
        String responseDesc = "Found some results";
        if (list == null || list.isEmpty()) {
            responseDesc = "No result found";
        }
        MyResponse resp = new MyResponse(responseDesc, list);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    /**
     * Save response entity.
     *
     * @param article the article
     * @return the response entity
     */
    @PostMapping("/save")
    public ResponseEntity<MyResponse> save(@RequestBody ArticleDto article) {
        ArticleDto resp = articleService.saveArticle(article);
        String responseDesc = "Article saved successfully";
        if (resp == null) {
            responseDesc = "Article not saved";
        }
        MyResponse result = new MyResponse(responseDesc, resp);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Delete by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<MyResponse> deleteById(@PathVariable Long id) {
        String responseBody = "Article with id [" + id + "] was successful deleted!";
        MyResponse resp = new MyResponse(responseBody, null);
        articleService.deleteArticleById(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
