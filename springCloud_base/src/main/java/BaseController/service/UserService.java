package BaseController.service;

import BaseController.dao.UserDao;
import BaseController.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;


    public List<User> findAll(){
       return  userDao.findAll();
    }
}
