package ssm.mapper;

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
public interface BookMapper {
    public List<Book> listAllBook()throws Exception;
    public Book queryByBookId(@Param("id")Integer id)throws Exception;
    public List<Book> queryByPersonId(@Param("id")String id)throws Exception;
    public int insertBook(@Param("book")Book book)throws Exception;
    public int deleteByBookId(@Param("id")Integer id)throws Exception;
    public int deleteByPersonId(@Param("personId")String personId)throws Exception;
    public int updateBook(@Param("book") Book book) throws Exception;
}
