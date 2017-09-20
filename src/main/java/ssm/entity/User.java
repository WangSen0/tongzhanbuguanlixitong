package ssm.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/14
 */
@Entity
public class User {
    @Column(name="id")
    private Integer id;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="name")

    private String name;
    @Column(name = "password")
    private String password;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public String toString(){
        return "User[id="+id.toString()+",name="+name+",introduction="+password+"]";
    }
}
