package exercise.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
public class UserDTO {
    private Long id;

    private String name;

    private String email;

    private Date createdAt;
}
