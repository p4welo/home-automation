package pl.p4welo.ha.mq.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Paweł Radomski on 2016-05-04.
 */
public class MqttUtilsTest {

    @Test
    public void createCommandTopicTest() {
        String homeId = "home123";
        String deviceId = "device123";
        assertEquals(MqttUtils.createCommandTopic(homeId, deviceId), "/" + homeId + "/" + deviceId + "/cmd");
    }

    @Test
    public void matchTopicTest() {
        assertTrue(MqttUtils.matchTopic("/home123/device123/status", "/#/#/status"));
        assertFalse(MqttUtils.matchTopic("/home123/status", "/#/#/status"));
        assertFalse(MqttUtils.matchTopic("", "/#/#/status"));
    }
}
