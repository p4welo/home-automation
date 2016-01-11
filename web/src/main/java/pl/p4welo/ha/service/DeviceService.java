package pl.p4welo.ha.service;

import pl.p4welo.ha.domain.Device;

/**
 * Created by Paweł Radomski on 2016-01-07.
 */
public interface DeviceService {

    void updateStatus(Device device, String status);

    Device getById(String deviceId);
}
