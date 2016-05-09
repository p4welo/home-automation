package pl.p4welo.ha.event.listener.device;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.p4welo.ha.domain.Device;
import pl.p4welo.ha.event.type.DeviceStatusEvent;
import pl.p4welo.ha.service.DeviceService;

import javax.annotation.Resource;

/**
 * Created by Paweł Radomski on 2016-05-09.
 */
@Component(NewDeviceIntroduction.BEAN_NAME)
public class NewDeviceIntroduction {

    public static final String BEAN_NAME = "newDeviceIntroduction";

    @Resource
    private DeviceService deviceService;

    @EventListener
    public void onApplicationEvent(DeviceStatusEvent event) {
        Device device = deviceService.getById(event.getDeviceId());
        if (device == null) {
            deviceService.introduceNew(event.getHomeId(), event.getDeviceId(), event.getStatus());
        }
    }
}
