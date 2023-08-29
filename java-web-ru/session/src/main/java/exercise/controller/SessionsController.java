package exercise.controller;

import java.util.Collections;
import java.util.Objects;

import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        var cookie = ctx.cookie("currentUser") == null ? "" : ctx.cookie("currentUser");
        var page = new MainPage(cookie);
        ctx.cookie("currentUser", cookie);
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        var cookie = ctx.cookie("currentUser") == null ? "" : ctx.cookie("currentUser");
        var page = new LoginPage(cookie, "");
        ctx.render("build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = Security.encrypt(Objects.requireNonNull(ctx.formParam("password")));

        var user = UsersRepository.findByName(name);

        if (user == null || !user.getPassword().equals(password)) {
            var error = "Wrong username or password";
            var page = new LoginPage(name, error);
            ctx.render("build.jte", Collections.singletonMap("page", page));
            return;
        }

        ctx.cookie("currentUser", name);
        ctx.redirect(NamedRoutes.rootPath());

    }

    public static void destroy(Context ctx) {
        ctx.cookie("currentUser", "");
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
