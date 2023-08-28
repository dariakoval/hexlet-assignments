package exercise.controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {
    static final int PER = 5;

    // BEGIN
    public static void index(Context ctx) {
        var numberOfPage = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        if (numberOfPage == 0) {
            numberOfPage = 1;
        }
        var offset = (numberOfPage - 1) * PER;
        var posts = PostRepository.getEntities();
        List<Post> sliceOfPosts = posts.subList(offset, offset + PER);

        var page = new PostsPage(sliceOfPosts, numberOfPage);
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id);

        if (post == null) {
            throw new NotFoundResponse("Page not found");
        }

        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
    // END
}
