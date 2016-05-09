package pl.p4welo.ha.mq.incoming.dispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;
import pl.p4welo.ha.mq.incoming.api.MqttTopics;
import pl.p4welo.ha.event.type.DeviceStatusEvent;

import static pl.p4welo.ha.mq.utils.MqttUtils.matchTopic;
import static pl.p4welo.ha.mq.utils.MqttUtils.resolveIncomingTopic;

/**
 * Created by PARADOMS on 15-09-05.
 */
@Component(MqttMessageDispatcher.BEAN_NAME)
public class MqttMessageDispatcher implements MessageHandler {

    public static final String BEAN_NAME = "mqttMessageDispatcher";

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {

        String topic = resolveIncomingTopic(message);
        if (matchTopic(topic, MqttTopics.DEVICE_STATUS)) {
            publisher.publishEvent(DeviceStatusEvent.fromMessage(message));
        }
    }
}
