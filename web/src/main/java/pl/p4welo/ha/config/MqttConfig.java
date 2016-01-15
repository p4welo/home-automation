package pl.p4welo.ha.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import pl.p4welo.ha.mq.incoming.dispatcher.MqttMessageDispatcher;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * Created by PARADOMS lightOn 15-09-01.
 */
@Configuration
public class MqttConfig {

    @Resource
    private MqttMessageDispatcher mqttMessageDispatcher;

    @Value("${mqtt.broker.url}")
    private String brokerUrl;

    @Value("${app.defaultUser.homeId}")
    private String homeId;

    @Bean
    public MqttPahoMessageDrivenChannelAdapter mqttInbound() {

        MqttPahoMessageDrivenChannelAdapter mqtt = new MqttPahoMessageDrivenChannelAdapter("localSub" + UUID.randomUUID().toString().trim().substring(0, 5), clientFactory(), "/" + homeId + "/#");
        mqtt.setQos(2);
        mqtt.setOutputChannel(outbount());
        mqtt.setAutoStartup(true);
        return mqtt;
    }

    @Bean
    public MqttPahoMessageHandler mqttMessageHandler() {

        return new MqttPahoMessageHandler("localPub" + UUID.randomUUID().toString().trim().substring(0, 5), clientFactory());
    }

    @Bean
    public DefaultMqttPahoClientFactory clientFactory() {

        DefaultMqttPahoClientFactory clientFactory = new DefaultMqttPahoClientFactory();
        clientFactory.setServerURIs(new String[]{brokerUrl});
        return clientFactory;
    }

    @Bean
    public PublishSubscribeChannel outbount() {

        PublishSubscribeChannel psc = new PublishSubscribeChannel();
        psc.subscribe(mqttMessageDispatcher);
        return psc;
    }
}
