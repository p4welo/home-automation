package pl.p4welo.ha.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import pl.p4welo.ha.domain.enums.DeviceTypeEnum;

/**
 * Created by Paweł Radomski on 2016-01-07.
 */
@Data
@Builder
public class Device {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String HOME_ID = "homeId";
    public static final String STATUS = "status";
    public static final String TYPE = "type";

    @Id
    private String id;
    private String name;
    private String homeId;
    private String status;
    private DeviceTypeEnum type;
}
