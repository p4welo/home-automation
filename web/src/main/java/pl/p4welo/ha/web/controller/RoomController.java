package pl.p4welo.ha.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static pl.p4welo.ha.web.api.RoomApiMappings.PREFIX;

/**
 * Created by Programist on 2015-10-26.
 */
@RestController
@RequestMapping(value = PREFIX)
@ResponseStatus(value = OK)
public class RoomController {

}
