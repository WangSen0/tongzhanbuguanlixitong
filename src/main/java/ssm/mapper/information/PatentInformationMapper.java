package ssm.mapper.information;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Patent;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/11/8
 */
@Repository
public interface PatentInformationMapper {
    public List<Patent> queryByPersonId(@Param("personId") String personId)throws Exception;
}
