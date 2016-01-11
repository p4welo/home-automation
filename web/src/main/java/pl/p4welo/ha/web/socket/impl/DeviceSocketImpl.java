package pl.p4welo.ha.web.socket.impl;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import pl.p4welo.ha.domain.Device;
import pl.p4welo.ha.web.socket.DeviceSocket;
import pl.p4welo.ha.web.socket.WebSocketApi;

import javax.annotation.Resource;

/**
 * Created by PARADOMS on 15-10-07.
 */
@Component(DeviceSocketImpl.BEAN_NAME)
public class DeviceSocketImpl implements DeviceSocket {

    public static final String BEAN_NAME = "deviceSocket";

    @Resource()
    private SimpMessagingTemplate template;

    @Override
    public void refreshStatus(Device device) {
        String path = WebSocketApi.refreshStatus(device);
        template.convertAndSend(path, device);
    }
}
