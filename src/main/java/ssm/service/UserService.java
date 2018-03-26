package ssm.service;

import org.apache.ibatis.annotations.Param;
import ssm.entity.User;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/26
 */
public interface UserService {
    public List<User> listAllUser()throws Exception;
    public User queryByUserId(Integer id)throws Exception;
    public User queryByNameAndPassword(User user)throws Exception;
    public int insertUser(User user)throws Exception;
    public int deleteByUserId(Integer id)throws Exception;
    public int updateUser(User user) throws Exception;
    public List<User> queryByLimit(String userName,Integer offerset,Integer rows)throws Exception;
    public User queryByUserName(String userName)throws Exception;
    public int updatePassword(String userName,String password)throws Exception;
}
