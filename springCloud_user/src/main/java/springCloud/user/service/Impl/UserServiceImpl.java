package springCloud.user.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import springCloud.user.dao.UserDao;
import springCloud.user.pojo.User;
import springCloud.user.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void insert(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public User login(User user) {
       User loginUser = userDao.findUserId(user.getId());
       if(loginUser == null || !encoder.matches(user.getPassword() , loginUser.getPassword())){
            return null;
       }
            return loginUser;
    }
}
