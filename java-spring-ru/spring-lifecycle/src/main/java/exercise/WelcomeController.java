package exercise;
import org.springframework.web.bind.annotation.GetMapping;

// BEGIN
import org.springframework.web.bind.annotation.RestController;
import exercise.daytimes.Daytime;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class WelcomeController {

    private final Daytime daytime;

    private final Meal meal;

    @GetMapping("/daytime")
    public String root() {
        String time = daytime.getName();
        return "It is " + time + " now. " + "Enjoy your " + meal.getMealForDaytime(time);
    }
}
// END
