package exercise;

import lombok.SneakyThrows;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    @SneakyThrows
    public static void save(Path path, Car car) {
        Path fullPath = path.toAbsolutePath().normalize();
        String content = car.serialize();
        Files.writeString(fullPath, content, StandardOpenOption.WRITE);

    }

    @SneakyThrows
    public static Car extract(Path path) {
        Path fullPath = path.toAbsolutePath().normalize();
        String content = Files.readString(fullPath);
        return Car.unserialize(content);
    }
}
// END
