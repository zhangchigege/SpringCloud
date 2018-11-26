package springCloud.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import springCloud.user.pojo.User;

public interface UserDao extends JpaRepository<User ,Integer> , JpaSpecificationExecutor<User>{


    @Modifying
    @Query(value = "select * from sys_user where id = ?" , nativeQuery = true)
    User findUserId(Integer id);
}
