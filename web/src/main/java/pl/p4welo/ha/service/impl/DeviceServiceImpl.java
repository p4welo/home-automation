package pl.p4welo.ha.service.impl;

import org.springframework.stereotype.Service;
import pl.p4welo.ha.dao.DeviceRepository;
import pl.p4welo.ha.domain.Device;
import pl.p4welo.ha.service.DeviceService;

import javax.annotation.Resource;

/**
 * Created by Paweł Radomski on 2016-01-07.
 */
@Service(DeviceServiceImpl.BEAN_NAME)
public class DeviceServiceImpl implements DeviceService {

    public static final String BEAN_NAME = "deviceService";

    @Resource
    private DeviceRepository deviceRepository;

    @Override
    public void updateStatus(Device device, String status) {
        Device old = deviceRepository.findOne(device.getId());
        old.setStatus(status);
        deviceRepository.save(old);
    }

    @Override
    public Device getById(String deviceId) {
        return deviceRepository.findOne(deviceId);
    }
}
