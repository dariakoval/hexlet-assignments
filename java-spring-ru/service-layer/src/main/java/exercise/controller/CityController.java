package exercise.controller;

import exercise.model.City;
import exercise.repository.CityRepository;
import exercise.service.WeatherService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
public class CityController {

    private final CityRepository cityRepository;

    private final WeatherService weatherService;

    // BEGIN
    @GetMapping(path = "/cities/{id}")
    public Map<String, String> getCityWeather(@PathVariable Long id) {
        return this.weatherService.getWeather(id);
    }

    @GetMapping(path = "/search")
    public List<Map<String, String>> getCityList(@RequestParam(value = "name", required = false) String name) {
        List<City> resultCities;
        if (name == null) {
            resultCities = cityRepository.findAllByOrderByName();
        } else {
            resultCities = cityRepository.findByNameIgnoreCaseStartingWith(name);
        }

        return resultCities.stream()
                .map(city -> {
                    Map<String, String> weather = weatherService.getWeather(city.getId());
                    return Map.of("name", city.getName(), "temperature", weather.get("temperature"));
                })
                .toList();
    }
    // END
}

