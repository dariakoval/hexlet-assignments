package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var page = ctx.queryParam("page");
            var per = ctx.queryParam("per");

            if (page == null) {
                page = "1";
            }

            if (per == null) {
                per = "5";
            }

            List<Map<String, String>> users = new ArrayList<>();

            int pageInt = Integer.parseInt(page);
            int perInt = Integer.parseInt(per);

            for (var i = perInt * pageInt - perInt; i < perInt * pageInt; i++) {
                var user = USERS.get(i);
                users.add(user);
            }

            ctx.json(users);
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
