package pl.p4welo.ha.mq.incoming.listener.device;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.p4welo.ha.domain.Device;
import pl.p4welo.ha.mq.incoming.event.DeviceStatusEvent;
import pl.p4welo.ha.service.DeviceService;

import javax.annotation.Resource;

/**
 * Created by PARADOMS on 15-10-01.
 */
@Component(DeviceStatusListener.BEAN_NAME)
public class DeviceStatusListener {

    public static final String BEAN_NAME = "deviceStatusListener";

    @Resource
    private DeviceService deviceService;

    @EventListener
    public void onApplicationEvent(DeviceStatusEvent event) {
        Device device = deviceService.getById(event.getDeviceId());
        deviceService.updateStatus(device, event.getStatus());
    }
}
