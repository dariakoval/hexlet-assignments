package exercise;

import exercise.daytimes.Daytime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// BEGIN
@RestController
public class WelcomeController {
    @Autowired
    Meal meal;

    @Autowired
    Daytime daytime;

    @GetMapping("/daytime")
    public String bonAppetitWish() {
        return "It is " + daytime.getName() + "now. " +
                "Enjoy your " + meal.getMealForDaytime(daytime.getName());
    }
}
// END
