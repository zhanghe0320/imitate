package imitate.project.activity.databinding.model;


import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

/**
 */

public class EmployeeInfo {
    private String avatar;
    private String name;
    private ObservableField<String> desc = new ObservableField<>();
    private ObservableBoolean isFired = new ObservableBoolean();

    public EmployeeInfo(String avatar, String name) {
        this.avatar = avatar;
        this.name = name;
        desc.set("desc");
        isFired.set(false);
    }

    public EmployeeInfo() {
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObservableField<String> getDesc() {
        return desc;
    }

    public void setDesc(String text) {
        this.desc.set(text);
    }

    public ObservableBoolean getIsFired() {
        return isFired;
    }

    public void setIsFired(boolean isFired) {
        this.isFired.set(isFired);
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", desc=" + desc .get()+
                ", isFired=" + isFired.get() +
                '}';
    }
}
