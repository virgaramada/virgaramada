package org.pelitur.apps.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * The type Article.
 */
@Entity
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long articleId;
    private String title;
    private String content;

}
