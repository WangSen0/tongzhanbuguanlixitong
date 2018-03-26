package ssm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 职责
 *著作
 * @author wangsen
 * @time 2017/9/21
 */
@Entity
public class Book {
    @Column(name ="id")
    private Integer id;
    @Column(name="book_id")
    private String bookId;
    @Column(name="person_id")
    private String personId;
    @Column(name="book_title")
    private String bookTitle;
    @Column(name="book_publish")
    private String bookPublish;

    public String getBookId() {
        return bookId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookPublish() {
        return bookPublish;
    }

    public void setBookPublish(String bookPublish) {
        this.bookPublish = bookPublish;
    }
}
