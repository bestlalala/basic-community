package com.bestlalala.community;

import com.bestlalala.community.entity.Article;
import com.bestlalala.community.repository.ArticleRepository;
import com.bestlalala.community.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class ArticleServiceTest {

    private final ArticleRepository articleRepository = Mockito.mock(ArticleRepository.class);
    private final ArticleService articleService = new ArticleService(articleRepository);

    @Test
    public void testGetAllArticles() {
        Article article1 = new Article();
        article1.setTitle("Article 1");
        article1.setContent("Content 1");

        Article article2 = new Article();
        article2.setTitle("Article 2");
        article2.setContent("Content 2");

        given(articleRepository.findAll()).willReturn(Arrays.asList(article1, article2));

        List<Article> articles = articleService.getAllArticles();

        assertThat(articles).hasSize(2);
        assertThat(articles.get(0).getTitle()).isEqualTo("Article 1");
    }
}
