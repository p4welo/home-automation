package pl.p4welo.ha.web.api;

/**
 * Created by PARADOMS on 15-09-30.
 */
public interface LightApiMappings extends CommonApiMapings {
    public static final String ENTITY = "light";
    public static final String PREFIX = "/" + ENTITY;
    public static final String TURN_ON = "/{" + ApiKeys.ID + "}/turnOn";
    public static final String TURN_OFF = "/{" + ApiKeys.ID + "}/turnOff";
}
