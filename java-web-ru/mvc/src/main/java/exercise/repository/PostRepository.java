package exercise.repository;

import java.util.List;
import java.util.ArrayList;
import exercise.model.Post;

public class PostRepository {
    private static List<Post> entities = new ArrayList<>();

    public static void save(Post post) {
        if (post.getId() == null) {
            post.setId((long) entities.size() + 1);
            entities.add(post);
        }
    }

    public static List<Post> search(String term) {
        var posts = entities.stream()
                .filter(entity -> entity.getName().startsWith(term))
                .toList();
        return posts;
    }

    public static Post find(Long id) {
        var post = entities.stream()
                .filter(entity -> entity.getId() == id)
                .findAny()
                .orElse(null);
        return post;
    }

    public static Post findByName(String name) {
        return entities.stream()
                .filter(entity -> entity.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public static boolean existsByName(String name) {
        return entities.stream()
                .anyMatch(value -> value.getName().equals(name));
    }

    public static List<Post> getEntities() {
        return entities;
    }

    public static void clear() {
        entities.clear();
    }
}
