package ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Paper;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Repository
public interface PaperMapper {
    public List<Paper> listAllPaper()throws Exception;
    public Paper queryByPaperId(@Param("id")Integer id)throws Exception;
    public List<Paper> queryByPersonId(@Param("id")String id)throws Exception;
    public int insertPaper(@Param("paper")Paper paper)throws Exception;
    public int deleteByPaperId(@Param("id")Integer id)throws Exception;
    public int deleteByPersonId(@Param("personId")String personId)throws Exception;
    public int updatePaper(@Param("paper") Paper paper) throws Exception;
}
