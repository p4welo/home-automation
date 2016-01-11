package pl.p4welo.ha.service;

import pl.p4welo.ha.domain.Device;

/**
 * Created by Paweł Radomski on 2016-01-07.
 */
public interface LightService extends DeviceService {

    void turnOn(Device device);

    void turnOff(Device device);
}
