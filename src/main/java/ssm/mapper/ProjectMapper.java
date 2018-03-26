package ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Project;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Repository
public interface ProjectMapper {
    public List<Project> listAllProject()throws Exception;
    public Project queryByProjectId(@Param("id")Integer id)throws Exception;
    public List<Project> queryByPersonId(@Param("id")String id)throws Exception;
    public int insertProject(@Param("project")Project project)throws Exception;
    public int deleteByProjectId(@Param("id")Integer id)throws Exception;
    public int deleteByPersonId(@Param("personId")String personId)throws Exception;
    public int updateProject(@Param("project") Project project) throws Exception;
}
