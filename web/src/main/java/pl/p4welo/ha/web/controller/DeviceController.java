package pl.p4welo.ha.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.p4welo.ha.service.DeviceService;

import javax.annotation.Resource;

import static org.springframework.http.HttpStatus.OK;
import static pl.p4welo.ha.web.api.DeviceApiMappings.PREFIX;

/**
 * Created by PARADOMS on 15-10-07.
 */
@RestController
@RequestMapping(value = PREFIX)
@ResponseStatus(value = OK)
public class DeviceController {

    @Resource
    private DeviceService deviceService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String turnOff() {
        return "jest ok";
    }
}
