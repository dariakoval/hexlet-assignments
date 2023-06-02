package exercise;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        Field[] fields = address.getClass().getDeclaredFields();
        return Arrays.stream(fields)
                .filter(x -> x.isAnnotationPresent(NotNull.class))
                .peek(x -> x.setAccessible(true))
                .filter(x -> {
                    try {
                        return x.get(address) == null;
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(Field::getName)
                .collect(Collectors.toList());

    }
    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> result = new HashMap<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field: fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true);
                    String s = (String) field.get(address);
                    if (s == null) {
                        result.put(field.getName(), List.of("can not be null"));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if (field.isAnnotationPresent(MinLength.class)) {
                try {
                    field.setAccessible(true);
                    int i = ((String) field.get(address)).length();
                    if (i < 4) {
                        result.put(field.getName(), List.of("length less than 4"));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
// END
