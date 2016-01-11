package pl.p4welo.ha.mq.command.device.light;

import pl.p4welo.ha.domain.Device;
import pl.p4welo.ha.mq.command.CommandBuilder;
import pl.p4welo.ha.mq.command.MqttCommand;
import pl.p4welo.ha.mq.utils.MqttUtils;

/**
 * Created by PARADOMS on 15-09-28.
 */
public class TurnOffLightCommand implements CommandBuilder {

    private Device light;

    private MqttCommand command;

    private TurnOffLightCommand() {
    }

    public static TurnOffLightCommand create() {
        return new TurnOffLightCommand();
    }

    public TurnOffLightCommand withLight(Device light) {
        this.light = light;
        return this;
    }

    @Override
    public MqttCommand getCommand() {
        command = new MqttCommand();
        command.setTopic(MqttUtils.createCommandTopic("home1", light.getId()));
        command.setPayload("0");
        return command;
    }
}
