package ru.dataart.tihonov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dataart.tihonov.dao.ArticleDAO;
import ru.dataart.tihonov.models.Article;

@Controller
@RequestMapping("/siteOfArticles")
public class ArticlesController {

    private ArticleDAO articleDAO;

    public ArticlesController(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    @GetMapping()
    public String showHomePage(Model model) {
        model.addAttribute("articles", articleDAO.showAllArticles());
        return "siteOfArticles/homePage";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("article", articleDAO.show(id));
        return "siteOfArticles/show";
    }

    @GetMapping("/downloadPage")
    public String newArticle(Model model) {
        model.addAttribute("article",new Article());
        return "siteOfArticles/downloadPage";
    }

    @PostMapping()
    public String create(@ModelAttribute("article") Article article) {
        articleDAO.addArticle(article);
        return "redirect:/siteOfArticles";
    }
}
