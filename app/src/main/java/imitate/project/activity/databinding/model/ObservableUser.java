package imitate.project.activity.databinding.model;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableArrayMap;
import imitate.project.BR;
/**
 * 双向绑定model
 */

public class ObservableUser extends BaseObservable {
    private String firstName;
    private String lastName;

    public ObservableArrayMap<String, String> arrayMap = new ObservableArrayMap<>();
    public ObservableArrayList<String> list = new ObservableArrayList<>();

    public ObservableUser(String firstName, String lastName) {
        this.lastName = lastName;
        this.firstName = firstName;

        arrayMap.put("hi", "hi");
        arrayMap.put("wan", "wan");
        arrayMap.put("xiao", "xiao");

        list.add("测试数据一");
        list.add("测试数据二");
        list.add("测试数据三");
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);//刷新某个值
    }
}
