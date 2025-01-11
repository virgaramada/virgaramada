package id.co.maybank.demo.repository;

import id.co.maybank.demo.model.Article;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Article repository.
 */
public interface ArticleRepository extends CrudRepository<Article, Long>{
}
