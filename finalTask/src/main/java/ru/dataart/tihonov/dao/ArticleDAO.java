package ru.dataart.tihonov.dao;

import org.springframework.stereotype.Component;
import ru.dataart.tihonov.models.Article;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleDAO {
    private static int ARTICLE_COUNT;
    private List<Article> articles = new ArrayList<>();

    {
        articles.add(new Article(++ARTICLE_COUNT, "DataArt is a software outsourcing company specializing in Internet applications, Internet of Things technologies, corporate databases and industrial automation tools, including client and content management systems. There are 20 sales and development centers, mainly on the territory of the former USSR, in which about 3,500 specialists work.",
                "Dataart"));
    }
    public List<Article> showAllArticles() {
        return articles;
    }

    public Article show(int id) {
        return articles.stream().filter(article -> article.getId() == id).findAny().orElse(null);
    }

    public void addArticle(Article article) {
        int i = article.getArticle().indexOf(' ');
        String name = article.getArticle().substring(0,i);
        String text = article.getArticle().substring(i);
        articles.add(new Article(++ARTICLE_COUNT,text, name));
    }
}
