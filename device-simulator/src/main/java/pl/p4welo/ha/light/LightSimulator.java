package pl.p4welo.ha.light;

import org.eclipse.paho.client.mqttv3.MqttException;
import pl.p4welo.ha.common.Device;

/**
 * Created by Paweł Radomski on 2016-05-05.
 */
public class LightSimulator {
    public static void main(String[] args) throws MqttException {
        System.out.println("============================================================");
        System.out.println("DEVICE SIMULATOR - LIGHT");
        System.out.println("============================================================");

        new Device("light1") {
            @Override
            public void onMessageArrived(String topic, String message) {
                System.out.println(topic + ": " + message);
            }
        };
    }
}