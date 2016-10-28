package pl.p4welo.ha.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.p4welo.ha.domain.Device;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;

/**
 * Created by pradomski on 14.09.16.
 */
@RestController
public class AuthController {

    @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
    public void logout(HttpServletRequest req) {
        HttpSession session= req.getSession();
        session.invalidate();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Principal login(Principal user) {
        return user;
    }
}
