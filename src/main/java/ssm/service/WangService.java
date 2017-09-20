package ssm.service;

import org.apache.ibatis.annotations.Param;
import ssm.entity.User;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/14
 */
public interface WangService  {
    public int newUser(User user)throws Exception;
    public int delById(int id)throws Exception;
    public List<User> listAllPerson()throws Exception;
    public User queryById(int id)throws Exception;
    public User queryByName(String name)throws Exception;
}
