package exercise.controller;

import java.util.Collections;
import java.util.Map;
import exercise.dto.CartPage;
import exercise.util.NamedRoutes;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import exercise.model.CartItem;
import org.eclipse.jetty.util.UrlEncoded;

import io.javalin.http.Context;


public class CartsController {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void index(Context ctx) throws Exception {
        var cookie = ctx.cookie("cart") == null ? "{}" : ctx.cookie("cart");

        Map<String, CartItem> cart = mapper.readValue(
                UrlEncoded.decodeString(cookie),
                new TypeReference<Map<String, CartItem>>() { }
        );

        var page = new CartPage(cart);
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }

    // BEGIN
    public static void addItem(Context ctx) throws Exception {
        var id = ctx.formParam("id");
        var name = ctx.formParam("name");

        var cookie = ctx.cookie("cart") == null ? "{}" : ctx.cookie("cart");

        Map<String, CartItem> cart = mapper.readValue(
                UrlEncoded.decodeString(cookie),
                new TypeReference<Map<String, CartItem>>() { }
        );

        cart.computeIfAbsent(id, k -> new CartItem(name, 0));
        cart.get(id).increaseCount();

        var encodedCart = UrlEncoded.encodeString(mapper.writeValueAsString(cart));
        ctx.cookie("cart", encodedCart);
        ctx.redirect(NamedRoutes.rootPath());
    }

    public static void cleanCart(Context ctx) throws Exception {
        var encodedCart = mapper.writeValueAsString("{}");
        ctx.cookie("cart", encodedCart);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
