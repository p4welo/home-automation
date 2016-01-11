package pl.p4welo.ha.web.socket;

import pl.p4welo.ha.domain.Device;

/**
 * Created by PARADOMS on 15-09-05.
 */
public class WebSocketApi {
    private WebSocketApi() {}

    public static final String WS_INIT = "/ws/init";
    public static final String WS_BROKER = "/ws/broker";
    public static final String WS_PREFIX = "/ws";

    public static String refreshStatus(Device device) {
        return String.format("%s/%s/%s", WS_BROKER, device.getHomeId(), device.getId());
    }
}
