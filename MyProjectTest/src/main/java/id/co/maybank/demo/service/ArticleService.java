package id.co.maybank.demo.service;

import id.co.maybank.demo.dto.ArticleDto;

import java.util.List;

/**
 * The interface Article service.
 */
public interface ArticleService {

    /**
     * Gets all articles.
     *
     * @return the all articles
     */
    List<ArticleDto> getAllArticles();

    /**
     * Save article article dto.
     *
     * @param article the article
     * @return the article dto
     */
    ArticleDto saveArticle(ArticleDto article);

    /**
     * Delete article by id.
     *
     * @param id the id
     */
    void deleteArticleById(long id);
}

