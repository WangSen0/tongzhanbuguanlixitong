package ssm.service;

import ssm.entity.Test;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/16
 */
public interface TestService {
    public List<Test> list()throws Exception;
}
