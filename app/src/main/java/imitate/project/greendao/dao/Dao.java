package imitate.project.greendao.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;

import java.io.Serializable;

import androidx.annotation.Nullable;

@Entity
public class Dao  implements Serializable {
    private static final long serialVersionUID = 1L;


    @Index(unique = true)  //唯一
    private String name ;

    @Nullable
    private String sex ;

    @Id // 自增长(autoincrement = true)   需要自增长的时候
    private Long id ;
    @Generated(hash = 1805822620)
    public Dao(String name, String sex, Long id) {
        this.name = name;
        this.sex = sex;
        this.id = id;
    }
    @Generated(hash = 384647155)
    public Dao() {
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
   
}
