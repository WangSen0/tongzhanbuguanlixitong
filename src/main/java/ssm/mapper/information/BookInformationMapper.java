package ssm.mapper.information;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Book;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/21
 */
@Repository
public interface BookInformationMapper {
    public List<Book> queryByPersonId(@Param("personId")String personId)throws Exception;
}
