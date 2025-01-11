package org.pelitur.apps.demo.repository;

import org.pelitur.apps.demo.model.Article;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Article repository.
 */
public interface ArticleRepository extends CrudRepository<Article, Long>{
}
