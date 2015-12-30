package pl.p4welo.ha.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.p4welo.ha.domain.Authentication;

/**
 * Created by Paweł Radomski on 2015-12-23.
 */
public interface AuthenticationRepository extends MongoRepository<Authentication, String> {

    Authentication findByLogin(String login);
}
