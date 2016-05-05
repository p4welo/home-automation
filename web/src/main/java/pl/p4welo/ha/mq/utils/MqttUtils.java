package pl.p4welo.ha.mq.utils;

import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;

/**
 * Created by PARADOMS on 15-09-30.
 */
public interface MqttUtils {

    static String createCommandTopic(String homeId, String deviceId) {
        return "/" + homeId + "/" + deviceId + "/cmd";
    }

    static String resolveIncomingTopic(Message<?> message) {
        return (String) message.getHeaders().get(MqttHeaders.TOPIC);
    }

    static boolean matchTopic(String topic, String pattern) {
        return !(topic == null || topic.length() == 0 || pattern == null) && topic.matches(pattern.replace("/", "\\/").replace("#", ".*"));
    }

}
