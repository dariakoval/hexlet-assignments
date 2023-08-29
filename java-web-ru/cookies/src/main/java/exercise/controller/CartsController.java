package exercise.controller;

import java.util.Collections;
import java.util.Map;
import exercise.dto.CartPage;
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
    
    // END
}
