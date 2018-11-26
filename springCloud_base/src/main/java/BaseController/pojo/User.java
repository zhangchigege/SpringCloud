package BaseController.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "sys_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{

    @Id
    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private String email;
    private String sex;


}
