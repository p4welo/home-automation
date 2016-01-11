package pl.p4welo.ha.web.socket;

import pl.p4welo.ha.domain.Device;

/**
 * Created by PARADOMS on 15-10-07.
 */
public interface DeviceSocket {
    void refreshStatus(Device device);
}
