package pl.p4welo.ha.mq.command;

import lombok.Builder;
import lombok.Data;

/**
 * Created by PARADOMS on 15-09-30.
 */
@Data
@Builder
public class MqttCommand {
    private String payload;
    private String topic;
}
