package springCloud.user.service;

import springCloud.user.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void insert(User user);

    User login(User user);
}
