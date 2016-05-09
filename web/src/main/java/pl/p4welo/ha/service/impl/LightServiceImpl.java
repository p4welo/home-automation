package pl.p4welo.ha.service.impl;

import org.springframework.stereotype.Service;
import pl.p4welo.ha.domain.Device;
import pl.p4welo.ha.service.LightService;

/**
 * Created by Paweł Radomski on 2016-01-07.
 */
@Service(LightServiceImpl.BEAN_NAME)
public class LightServiceImpl extends DeviceServiceImpl implements LightService {

    public static final String BEAN_NAME = "lightService";

    @Override
    public void turnOn(Device device) {

    }

    @Override
    public void turnOff(Device device) {

    }
}
