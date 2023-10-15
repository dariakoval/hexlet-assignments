package exercise.controller;

import exercise.dto.ArticleDto;
import exercise.model.Article;
import exercise.repository.ArticleRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticlesController {

    private final ArticleRepository articleRepository;

    @GetMapping(path = "")
    public Iterable<Article> getArticles() {
        return articleRepository.findAll();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteArticle(@PathVariable long id) {
        articleRepository.deleteById(id);
    }

    // BEGIN
    @PostMapping(path = "")
    public Article create(@RequestBody ArticleDto articleDto) {
        var article = new Article();
        article.setName(articleDto.getName());
        article.setBody(articleDto.getBody());
        article.setCategory(articleDto.getCategory());
        return articleRepository.save(article);
    }

    @PatchMapping(path = "/{id}")
    public Article update(@RequestBody ArticleDto articleDto, @PathVariable Long id) {
        var article = articleRepository.findById(id).get();
        article.setName(articleDto.getName());
        article.setBody(articleDto.getBody());
        article.setCategory(articleDto.getCategory());
        return articleRepository.save(article);
    }

    @GetMapping(path = "/{id}")
    public Article show(@PathVariable Long id) {
        var article = articleRepository.findById(id).get();
        return article;
    }
    // END
}
