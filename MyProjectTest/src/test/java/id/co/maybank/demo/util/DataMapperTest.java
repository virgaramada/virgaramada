package id.co.maybank.demo.util;


import id.co.maybank.demo.dto.ArticleDto;
import id.co.maybank.demo.model.Article;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Data mapper test.
 */
class DataMapperTest {

    private DataMapper dataMapper;

    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        dataMapper = new DataMapper();
    }

    /**
     * When convert article entity to article dto then correct.
     */
    @Test
    void whenConvertArticleEntityToArticleDto_thenCorrect() {
        Article article = new Article();
        article.setArticleId(1L);
        article.setTitle("title1");
        article.setContent("www.test.com");

        ArticleDto articleDto = dataMapper.map(article, ArticleDto.class);
        assertEquals(article.getArticleId(), articleDto.getArticleId());
        assertEquals(article.getTitle(), articleDto.getTitle());
        assertEquals(article.getContent(), articleDto.getContent());
    }

    /**
     * When convert article dto to article entity then correct.
     */
    @Test
    void whenConvertArticleDtoToArticleEntity_thenCorrect() {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setArticleId(1L);
        articleDto.setTitle("title1");
        articleDto.setContent("www.test.com");

        Article article = dataMapper.map(articleDto, Article.class);
        assertEquals(articleDto.getArticleId(), article.getArticleId());
        assertEquals(articleDto.getTitle(), article.getTitle());
        assertEquals(articleDto.getContent(), article.getContent());
    }

    /**
     * When convert article entity list to article dto list then correct.
     */
    @Test
    void whenConvertArticleEntityListToArticleDtoList_thenCorrect() {
        Article article = new Article();
        article.setArticleId(1L);
        article.setTitle("title1");
        article.setContent("www.test.com");

        List<Article> list = new ArrayList<>();
        list.add(article);

        List<ArticleDto> articleDtoList = dataMapper.mapList(list, ArticleDto.class);
        for (ArticleDto articleDto: articleDtoList) {
            assertEquals(article.getArticleId(), articleDto.getArticleId());
            assertEquals(article.getTitle(), articleDto.getTitle());
            assertEquals(article.getContent(), articleDto.getContent());
        }

    }

    /**
     * When convert article dto list to article entity list then correct.
     */
    @Test
    void whenConvertArticleDtoListToArticleEntityList_thenCorrect() {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setArticleId(1L);
        articleDto.setTitle("title1");
        articleDto.setContent("www.test.com");

        List<ArticleDto> list = new ArrayList<>();
        list.add(articleDto);

        List<Article> articleList = dataMapper.mapList(list, Article.class);
        for (Article article: articleList) {
            assertEquals(articleDto.getArticleId(), article.getArticleId());
            assertEquals(articleDto.getTitle(), article.getTitle());
            assertEquals(articleDto.getContent(), article.getContent());
        }
    }

    /**
     * Tear down.
     */
    @AfterEach
    public void tearDown() {
        dataMapper = null;
    }
}
