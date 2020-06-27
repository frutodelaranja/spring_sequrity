package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.Role;
import web.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(2L));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public User findByLogin(String login) {
        return userDao.findByUsername(login);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public void edit(User user) {

        User editUser = findById(user.getId());
        for (Role role :
                user.getRoles()) {

            System.out.printf(role.toString());
        }
        Set<Role> editRoles;
        editUser.setName(user.getName());
        editUser.setUsername(user.getUsername());
        editUser.setPassword(user.getPassword());
        if (user.getRoles().isEmpty()){
            userDao.editUser(editUser);
        }else {
            editUser.setRoles(user.getRoles());
            userDao.editUser(editUser);
        }

    }
}
