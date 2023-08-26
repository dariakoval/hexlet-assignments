package exercise.repository;

import java.util.ArrayList;
import java.util.List;

import exercise.model.Article;
import lombok.Getter;

public class ArticleRepository {
    @Getter
    private static List<Article> entities = new ArrayList<Article>();

    public static void save(Article article) {
        article.setId((long) entities.size() + 1);
        entities.add(article);
    }

    public static List<Article> search(String term) {
        return entities.stream()
                .filter(entity -> entity.getTitle().startsWith(term))
                .toList();
    }

    public static Article find(Long id) {
        return entities.stream()
                .filter(entity -> entity.getId() == id)
                .findAny()
                .orElse(null);
    }

    public static Article findByTitle(String title) {
        return entities.stream()
                .filter(entity -> entity.getTitle().equals(title))
                .findAny()
                .orElse(null);
    }

    public static boolean existsByTitle(String title) {
        return entities.stream()
                .anyMatch(value -> value.getTitle().equals(title));
    }

    public static void clear() {
        entities.clear();
    }
}
