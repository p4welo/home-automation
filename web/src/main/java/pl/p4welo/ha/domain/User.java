package pl.p4welo.ha.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by Paweł Radomski on 2015-12-23.
 */
@Data
@Builder
public class User {

    public static final String LOGIN = "login";
    public static final String EMAIL = "email";

    @Id
    private String id;
    private String login;
    private String email;
}
