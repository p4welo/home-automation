package pl.p4welo.ha.mq.command;

/**
 * Created by PARADOMS on 15-10-01.
 */
public interface CommandBuilder {
    MqttCommand getCommand();
}
