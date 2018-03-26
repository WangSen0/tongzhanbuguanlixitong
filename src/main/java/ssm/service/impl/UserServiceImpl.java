package ssm.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssm.entity.User;
import ssm.mapper.UserMapper;
import ssm.service.UserService;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/26
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> listAllUser()throws Exception{
        return  userMapper.listAllUser();
    }
    @Override
    public User queryByUserId(Integer id)throws Exception{
        return userMapper.queryByUserId(id);
    }
    @Override
    public User queryByNameAndPassword(User user)throws Exception{
        return userMapper.queryByNameAndPassword(user);
    }
    @Override
    public int insertUser(User user)throws Exception{
        return userMapper.insertUser(user);
    }
    @Override
    public int deleteByUserId(Integer id)throws Exception{
        return userMapper.deleteByUserId(id);
    }
    @Override
    public int updateUser(User user) throws Exception{
        return userMapper.updateUser(user);
    }
    @Override
    public List<User> queryByLimit(String userName,Integer offerset,Integer rows)throws Exception{
        return userMapper.queryByLimit(userName,offerset,rows);
    }
    @Override
    public User queryByUserName(String userName)throws Exception{
        return userMapper.queryByUserName(userName);
    }
    @Override
    public int updatePassword(String userName,String password)throws Exception{
        return userMapper.updatePassword(userName,password);
    }
}
