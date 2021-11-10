package ru.dataart.tihonov.models;

public class Article {
    private int id;
    private String article;
    private String name;

    public Article(int id, String article, String name) {
        this.id = id;
        this.article = article;
        this.name = name;
    }

    public Article(int id, String article) {
        this.id = id;
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Article() {
    }

    public String getArticle() {
        return article;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArticle(String article, int id) {
        this.article = article;
        this.id = id;
    }

    public Article(String article) {
        this.article = article;
    }
}
