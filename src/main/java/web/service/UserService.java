package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User findById(Long id);

    User findByLogin(String login);

    List<User> listUsers();

    void delete(Long id);

    void edit(User user);
}
