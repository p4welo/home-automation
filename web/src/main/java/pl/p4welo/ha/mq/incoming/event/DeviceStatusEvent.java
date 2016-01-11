package pl.p4welo.ha.mq.incoming.event;

import org.springframework.messaging.Message;
import pl.p4welo.ha.mq.utils.MqttUtils;

/**
 * Created by PARADOMS on 15-10-01.
 */
public class DeviceStatusEvent {
    private String homeId;

    private String deviceId;

    private String status;

    private DeviceStatusEvent() {
    }

    public static DeviceStatusEvent fromMessage(Message<?> message) {
        String topic = MqttUtils.resolveIncomingTopic(message);
        String[] parts = topic.split("/");

        DeviceStatusEvent event = new DeviceStatusEvent();
        event.setHomeId(parts[1]);
        event.setDeviceId(parts[2]);
        event.setStatus((String) message.getPayload());
        return event;
    }

    public String getHomeId() {
        return homeId;
    }

    public void setHomeId(String homeId) {
        this.homeId = homeId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
