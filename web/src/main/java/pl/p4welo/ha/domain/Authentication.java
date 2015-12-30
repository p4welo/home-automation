package pl.p4welo.ha.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by Paweł Radomski on 2015-12-23.
 */
@Data
@Builder
public class Authentication {

    @Id
    private String id;
    private String login;
    private String password;
}
