package org.pelitur.apps.demo.service.impl;

import org.pelitur.apps.demo.dto.ArticleDto;
import org.pelitur.apps.demo.model.Article;
import org.pelitur.apps.demo.repository.ArticleRepository;
import org.pelitur.apps.demo.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

import org.pelitur.apps.demo.util.DataMapper;

/**
 * The type Article service.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    /**
     * The Article repository.
     */
    ArticleRepository articleRepository;

    /**
     * Instantiates a new Article service.
     *
     * @param articleRepository the article repository
     */
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    @Override
    public List<ArticleDto> getAllArticles() {
        Iterable<Article> iterable =  articleRepository.findAll();
        List<Article> articleList =
                StreamSupport.stream(iterable.spliterator(), false)
                .toList();

        DataMapper dataMapper = new DataMapper();
        return dataMapper.mapList(articleList, ArticleDto.class);
    }

    @Override
    public ArticleDto saveArticle(ArticleDto article) {
        DataMapper dataMapper = new DataMapper();
        Article request = dataMapper.map(article, Article.class);
        Article result = articleRepository.save(request);
         return dataMapper.map(result, ArticleDto.class);
    }

    @Override
    public void deleteArticleById(long id) {
         articleRepository.deleteById(id);
    }
}
