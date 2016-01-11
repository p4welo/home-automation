package pl.p4welo.ha.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.p4welo.ha.domain.Device;
import pl.p4welo.ha.service.DeviceService;
import pl.p4welo.ha.service.LightService;
import pl.p4welo.ha.web.api.ApiKeys;

import javax.annotation.Resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static pl.p4welo.ha.web.api.LightApiMappings.*;

/**
 * Created by PARADOMS on 15-09-29.
 */
@RestController
@RequestMapping(value = PREFIX)
@ResponseStatus(value = OK)
public class LightController {

    @Resource
    private DeviceService deviceService;

    @Resource
    private LightService lightService;

    @RequestMapping(value = TURN_ON, method = GET)
    public void turnOn(@PathVariable(ApiKeys.ID) String id) {
        Device device = deviceService.getById(id);
        lightService.turnOn(device);
    }

    @RequestMapping(value = TURN_OFF, method = GET)
    public void turnOff(@PathVariable(ApiKeys.ID) String id) {
        Device device = lightService.getById(id);
        lightService.turnOff(device);
    }
}
