package exercise.controller;

import java.util.Collections;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import exercise.dto.CartPage;
import exercise.util.NamedRoutes;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import exercise.model.CartItem;
import org.eclipse.jetty.util.UrlEncoded;

import io.javalin.http.Context;
public class PostController {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void create(Context ctx) throws JsonProcessingException {
        var id = ctx.formParam("id");
        var name = ctx.formParam("name");
        var cookie = ctx.cookie("cart") == null ? "{}" : ctx.cookie("cart");

        Map<String, CartItem> cart = mapper.readValue(
                UrlEncoded.decodeString(cookie),
                new TypeReference<Map<String, CartItem>>() { }
        );

        if (cart.containsKey(id)) {
            cart.get(id).increaseCount();
        } else {
            cart.put(id, new CartItem(name, 1));
        }

        ctx.redirect(NamedRoutes.rootPath());

        String json = "";
        try {
            json = mapper.writeValueAsString(cart);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        var encodedJson = UrlEncoded.encodeString(json);
        ctx.cookie("cart", encodedJson);
    }

    public static void clear(Context ctx) throws JsonProcessingException {
        var cookie = "{}";

        Map<String, CartItem> cart = mapper.readValue(
                UrlEncoded.decodeString(cookie),
                new TypeReference<Map<String, CartItem>>() { }
        );
        ctx.redirect(NamedRoutes.rootPath());
        ctx.cookie("cart", cookie);
    }
}
