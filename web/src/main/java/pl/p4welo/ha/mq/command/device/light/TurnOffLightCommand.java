package pl.p4welo.ha.mq.command.device.light;

import lombok.Builder;
import lombok.Data;
import pl.p4welo.ha.domain.Device;
import pl.p4welo.ha.mq.command.CommandBuilder;
import pl.p4welo.ha.mq.command.MqttCommand;
import pl.p4welo.ha.mq.utils.MqttUtils;

/**
 * Created by PARADOMS on 15-09-28.
 */
@Data
@Builder
public class TurnOffLightCommand implements CommandBuilder {

    private Device light;

    @Override
    public MqttCommand getCommand() {
        return MqttCommand.builder()
                .topic(MqttUtils.createCommandTopic("home1", light.getId()))
                .payload("0")
                .build();
    }
}
