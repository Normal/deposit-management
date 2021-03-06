package ru.spb.yarish.dm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ru.spb.yarish.dm.repository.AccountRepository;
import ru.spb.yarish.dm.model.entity.Account;

/**
 * Links our users with spring security.
 * @see ru.spb.yarish.dm.config.SecurityConfig
 */
@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private AccountRepository userDao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Account user = userDao.getByName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User wasn't found"));
        return new User(user.getName(), user.getPassword(),
                        AuthorityUtils.createAuthorityList(user.getRole().toString()));
    }
}
