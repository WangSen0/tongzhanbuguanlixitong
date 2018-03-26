package ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.User;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/26
 */
@Repository
public interface UserMapper {
    public List<User> listAllUser()throws Exception;
    public User queryByUserId(@Param("id")Integer id)throws Exception;
    public User queryByNameAndPassword(@Param("user")User user)throws Exception;
    public int insertUser(@Param("user")User user)throws Exception;
    public int deleteByUserId(@Param("id")Integer id)throws Exception;
    public int deleteByPersonId(@Param("personId")String personId)throws Exception;
    public int updateUser(@Param("user") User user) throws Exception;
    public User queryByUserName(@Param("userName")String userName)throws Exception;
    public List<User> queryByLimit(@Param("userName")String userName,@Param("offerset")Integer offerset,@Param("rows")Integer rows)throws Exception;
    public int updatePassword(@Param("userName")String userName,@Param("password") String password)throws Exception;
}
