package imitate.project.activity.databinding;


<<<<<<< HEAD
<<<<<<< HEAD
import java.io.Serializable;

import androidx.databinding.InverseMethod;

public class User implements Serializable {//序列化操作
    private static final long serialVersionUID = 1L;//序列化  保持版本兼容性，对象一致性  默认1L
                                                    //serialVersionUID作用：
                                                    //序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。
=======

public class User {
>>>>>>> 3fef1f0... 增加说明
=======
import java.io.Serializable;

import androidx.databinding.InverseMethod;

public class User implements Serializable {//序列化操作
    private static final long serialVersionUID = 1L;//序列化  保持版本兼容性，对象一致性  默认1L
                                                    //serialVersionUID作用：
                                                    //序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。
>>>>>>> 6b88e5c... 增加说明
    private String name;
    private String password;
    private String sex;
    private String age;

<<<<<<< HEAD
<<<<<<< HEAD
    private int age0;
=======
    public User(String name,String age,String password,String sex) {
        this.age=age;
        this.name =name;
        this.password = password;
        this.sex = sex;
    }
>>>>>>> 3fef1f0... 增加说明
=======
    private int age0;
>>>>>>> 9e27b5b... 增加说明

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
<<<<<<< HEAD
<<<<<<< HEAD
                ", age='" + age + '\'' +
<<<<<<< HEAD
                ", age0=" + age0 +
                '}';
    }

    public int getAge0() {
        return age0;
    }

    public void setAge0(int age0) {
        this.age0 = age0;
    }

    public User(String name, String age, String password, String sex) {
        this.age=age;
        this.name =name;
        this.password = password;
        this.sex = sex;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

=======
                '}';
    }

>>>>>>> 3fef1f0... 增加说明
=======
                ", age=" + age +
=======
                ", age='" + age + '\'' +
                ", age0=" + age0 +
>>>>>>> 9e27b5b... 增加说明
                '}';
    }

    public int getAge0() {
        return age0;
    }

    public void setAge0(int age0) {
        this.age0 = age0;
    }

    public User(String name, String age, String password, String sex) {
        this.age=age;
        this.name =name;
        this.password = password;
        this.sex = sex;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

>>>>>>> 6b88e5c... 增加说明
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
