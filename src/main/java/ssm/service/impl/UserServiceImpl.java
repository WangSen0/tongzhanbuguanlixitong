package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.entity.User;
import ssm.mapper.UserMapper;
import ssm.service.UserService;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/14
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public int newUser(User user)throws Exception{
        return userMapper.newUser(user);
    }
    @Override
    public int delById(int id)throws Exception{
        return userMapper.delById(id);
    }
    @Override
    public List<User> listAllPerson()throws Exception{
        return userMapper.listAllPerson();
    }
    @Override
    public User queryById(int id)throws Exception{
        User user=userMapper.queryById(id);
        return user;
    }
    @Override
    public int update(User user)throws Exception{
        return userMapper.update(user);
    }
    @Override
    public User queryByNameAndPassword(String name,String password) throws Exception{
        User user=userMapper.queryByNameAndPassword(name,password);
        return user;
    }
    @Override
    public User queryByName(String name)throws Exception{
        User user=userMapper.queryByName(name);
        return user;
    }
}
