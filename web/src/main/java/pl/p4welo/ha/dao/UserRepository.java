package pl.p4welo.ha.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.p4welo.ha.domain.User;

/**
 * Created by Paweł Radomski on 2015-12-23.
 */
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends MongoRepository<User, String> {

    User findByLogin(@Param(User.LOGIN) String login);
}
