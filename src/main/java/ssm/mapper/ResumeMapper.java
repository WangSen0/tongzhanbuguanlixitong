package ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Resume;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Repository
public interface ResumeMapper {
    public List<Resume> listAllResume()throws Exception;
    public Resume queryByResumeId(@Param("id")Integer id)throws Exception;
    public List<Resume> queryByPersonId(@Param("id")String id)throws Exception;
    public int insertResume(@Param("resume")Resume resume)throws Exception;
    public int deleteByResumeId(@Param("id")Integer id)throws Exception;
    public int deleteByPersonId(@Param("personId")String personId)throws Exception;
    public int updateResume(@Param("resume") Resume resume) throws Exception;
}
