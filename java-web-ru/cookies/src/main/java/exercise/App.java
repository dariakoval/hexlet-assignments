package exercise;

import exercise.controller.PostController;
import io.javalin.Javalin;
import exercise.controller.CartsController;
import exercise.util.NamedRoutes;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get(NamedRoutes.rootPath(), CartsController::index);
        // BEGIN
        app.post(NamedRoutes.addItemPath(), PostController::create);
        app.post(NamedRoutes.clearCartPath(), PostController::clear);
        // END



        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
