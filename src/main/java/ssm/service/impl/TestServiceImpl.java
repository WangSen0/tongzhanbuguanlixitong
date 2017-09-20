package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.entity.Test;
import ssm.mapper.TestMapper;
import ssm.service.TestService;

import java.util.ArrayList;
import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/16
 */
@Service("testService")
public class TestServiceImpl implements TestService{
    @Autowired
    TestMapper testMapper;
    @Override
    public List<Test> list()throws Exception{
        List<Test>list=testMapper.list();
        return list;
    }
}
