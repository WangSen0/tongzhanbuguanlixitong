package ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Report;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Repository
public interface ReportMapper {
    public List<Report> listAllReport()throws Exception;
    public Report queryByReportId(@Param("id")Integer id)throws Exception;
    public List<Report> queryByPersonId(@Param("id")String id)throws Exception;
    public int insertReport(@Param("report")Report report)throws Exception;
    public int deleteByReportId(@Param("id")Integer id)throws Exception;
    public int deleteByPersonId(@Param("personId")String personId)throws Exception;
    public int updateReport(@Param("report") Report report) throws Exception;
}
