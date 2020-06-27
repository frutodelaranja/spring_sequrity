package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;

@Service
public class UserDetailsServiceImp implements UserDetailsService{

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String username){
        return userDao.findByUsername(username);
    }
}
