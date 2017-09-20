package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.entity.User;
import ssm.mapper.UserMapper;
import ssm.mapper.WangMapper;
import ssm.service.UserService;
import ssm.service.WangService;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/14
 */
@Service("wangService")
public class WangServiceImpl implements WangService {
    @Autowired
    WangMapper wangMapper;
    @Override
    public int newUser(User user)throws Exception{
        return wangMapper.newUser(user);
    }
    @Override
    public int delById(int id)throws Exception{
        return wangMapper.delById(id);
    }
    @Override
    public List<User> listAllPerson()throws Exception{
        return wangMapper.listAllPerson();
    }
    @Override
    public User queryById(int id)throws Exception{
        User user=wangMapper.queryById(id);
        return user;
    }

    @Override
    public User queryByName(String name)throws Exception{
        User user=wangMapper.queryByName(name);
        return user;
    }
}
