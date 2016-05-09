package pl.p4welo.ha.mq.incoming.event;

import lombok.Builder;
import lombok.Data;
import org.springframework.messaging.Message;
import pl.p4welo.ha.mq.utils.MqttUtils;

/**
 * Created by PARADOMS on 15-10-01.
 */
@Data
@Builder
public class DeviceStatusEvent {
    private String homeId;
    private String deviceId;
    private String status;

    public static DeviceStatusEvent fromMessage(Message<?> message) {
        String topic = MqttUtils.resolveIncomingTopic(message);
        String[] parts = topic.split("/");

        return DeviceStatusEvent.builder()
                .homeId(parts[1])
                .deviceId(parts[2])
                .status((String) message.getPayload())
                .build();
    }
}
