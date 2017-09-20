package ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;
import ssm.entity.User;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/14
 */
@Repository
public interface UserMapper {
    public int newUser(@Param("user")User user)throws Exception;
    public User queryByName(@Param("name")String name)throws Exception;
    public int delById(@Param("id")Integer id)throws Exception;
    public List<User> listAllPerson()throws Exception;
    public User queryById(@Param("id")Integer id)throws Exception;
    public int update(@Param("user")User user)throws Exception;
    public User queryByNameAndPassword(@Param("name") String name,@Param("password") String password) throws Exception;
}
