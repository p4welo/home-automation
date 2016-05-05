package pl.p4welo.ha.common;

import org.eclipse.paho.client.mqttv3.*;

/**
 * Created by Paweł Radomski on 2016-05-05.
 */
public abstract class Device {

    private MqttClient client;

    public Device(String deviceId) throws MqttException {
        client = new MqttClient("tcp://test.mosquitto.org:1883", deviceId);
        client.connect();
        client.setCallback(new MqttCallback() {
            public void connectionLost(Throwable throwable) {
            }

            public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
                onMessageArrived(s, mqttMessage.toString());
            }

            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
            }
        });
        client.subscribe("/home1/" + deviceId + "/#");
        System.out.println(deviceId + " has been connected.");
    }

    public abstract void onMessageArrived(String topic, String message);
}
