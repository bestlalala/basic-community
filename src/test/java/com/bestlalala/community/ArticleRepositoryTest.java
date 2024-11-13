package com.bestlalala.community;

import com.bestlalala.community.entity.Article;
import com.bestlalala.community.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void testSaveAndFindAll() {
        Article article = new Article();
        article.setTitle("Test Title");
        article.setContent("Test Content");

        articleRepository.save(article);

        List<Article> articles = articleRepository.findAll();
        assertThat(articles).isNotEmpty();
        assertThat(articles.get(0).getTitle()).isEqualTo("Test Title");
    }
}
