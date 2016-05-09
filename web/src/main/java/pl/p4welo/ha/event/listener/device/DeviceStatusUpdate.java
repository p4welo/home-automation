package pl.p4welo.ha.event.listener.device;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.p4welo.ha.domain.Device;
import pl.p4welo.ha.event.type.DeviceStatusEvent;
import pl.p4welo.ha.service.DeviceService;

import javax.annotation.Resource;

/**
 * Created by PARADOMS on 15-10-01.
 */
@Component(DeviceStatusUpdate.BEAN_NAME)
public class DeviceStatusUpdate {

    public static final String BEAN_NAME = "deviceStatusUpdate";

    @Resource
    private DeviceService deviceService;

    @EventListener
    public void onApplicationEvent(DeviceStatusEvent event) {
        Device device = deviceService.getById(event.getDeviceId());
        if (device != null) {
            deviceService.updateStatus(device, event.getStatus());
        }
    }
}
