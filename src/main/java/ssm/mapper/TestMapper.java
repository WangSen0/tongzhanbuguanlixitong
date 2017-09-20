package ssm.mapper;

import org.springframework.stereotype.Repository;
import ssm.entity.Test;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/16
 */
@Repository
public interface TestMapper {
    public List<Test> list()throws Exception;
}
