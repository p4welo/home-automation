package pl.p4welo.ha.mq.command.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import pl.p4welo.ha.mq.command.MqttCommand;

/**
 * Created by PARADOMS on 15-09-07.
 */
@Component
public class MqttMessagePublisher {

    @Autowired
    private MqttPahoMessageHandler mqtt;

    public void publish(MqttCommand command) {
        Message<String> message = MessageBuilder
                .withPayload(command.getPayload())
                .setHeader(MqttHeaders.TOPIC, command.getTopic())
                .build();

        mqtt.handleMessage(message);
    }
}
