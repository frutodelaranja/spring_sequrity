package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    User findById(Long id);

    List<User> listUsers();

    void delete(Long id);

    void editUser(User user);

    User findByUsername(String username);
}
