package pl.p4welo.ha.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.p4welo.ha.dao.AuthenticationRepository;
import pl.p4welo.ha.dao.UserRepository;
import pl.p4welo.ha.domain.Authentication;
import pl.p4welo.ha.domain.User;
import pl.p4welo.ha.service.UserService;

import javax.annotation.Resource;

/**
 * Created by Paweł Radomski on 2015-12-23.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private AuthenticationRepository authenticationRepository;

    @Resource
    private UserRepository userRepository;

    @Value("${app.defaultUser.login}")
    private String defaultLogin;

    @Value("${app.defaultUser.password}")
    private String defaultPassword;

    @Override
    @Transactional(readOnly = true)
    public boolean isEmpty() {
        return userRepository.count() == 0;
    }

    @Override
    @Transactional
    public void createDefaultUser() {
        Authentication authentication = Authentication.builder()
                .login(defaultLogin)
                .password(defaultPassword)
                .build();

        User user = User.builder()
                .login(authentication.getLogin())
                .build();

        authenticationRepository.save(authentication);
        userRepository.save(user);
    }
}
