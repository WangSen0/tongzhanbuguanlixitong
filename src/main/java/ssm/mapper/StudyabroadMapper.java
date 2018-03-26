package ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Studyabroad;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Repository
public interface StudyabroadMapper {
    public List<Studyabroad> listAllStudyabroad()throws Exception;
    public Studyabroad queryByStudyabroadId(@Param("id")Integer id)throws Exception;
    public List<Studyabroad> queryByPersonId(@Param("id")String id)throws Exception;
    public int insertStudyabroad(@Param("studyabroad")Studyabroad studyabroad)throws Exception;
    public int deleteByStudyabroadId(@Param("id")Integer id)throws Exception;
    public int deleteByPersonId(@Param("personId")String personId)throws Exception;
    public int updateStudyabroad(@Param("studyabroad") Studyabroad studyabroad) throws Exception;
    public List<String> queryStudyabroadCountry()throws Exception;
}
