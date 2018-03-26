package ssm.mapper.information;

import org.apache.ibatis.annotations.Param;
import ssm.entity.Patent;
import ssm.entity.Project;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/11/8
 */
public interface ProjectInformationMapper {
    public List<Project> queryByPersonId(@Param("personId") String personId)throws Exception;
}
