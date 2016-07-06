package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by beangou on 16/7/2.
 */

@Entity
@Table(name = "my_course")
public class Course extends Model {

    @Id
    public Integer id;

    public Integer type;

    public String title;

    public String content;

    public Integer parentId;

    public Date createdAt;

    public Date updatedAt;

    public static Finder<Long, Course> find = new Finder<>(Course.class);

    public void setId(Integer id) {

        this.id = id;

    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public Integer getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Integer getParentId() {
        return parentId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
