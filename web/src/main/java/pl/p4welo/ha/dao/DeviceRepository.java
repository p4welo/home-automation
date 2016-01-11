package pl.p4welo.ha.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.p4welo.ha.domain.Device;
import pl.p4welo.ha.web.api.DeviceApiMappings;

/**
 * Created by Paweł Radomski on 2016-01-07.
 */
@RepositoryRestResource(collectionResourceRel = DeviceApiMappings.ENTITY, path = DeviceApiMappings.ENTITY)
public interface DeviceRepository extends MongoRepository<Device, String> {

}
