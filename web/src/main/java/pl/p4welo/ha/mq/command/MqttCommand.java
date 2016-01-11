package pl.p4welo.ha.mq.command;

/**
 * Created by PARADOMS on 15-09-30.
 */
public class MqttCommand {
    private String payload;
    private String topic;

    public String getPayload() {
        return payload;
    }

    public String getTopic() {
        return topic;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
