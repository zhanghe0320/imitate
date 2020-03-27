package imitate.project.activity.databinding.utils;

import java.util.ArrayList;
import java.util.List;

import imitate.project.activity.databinding.model.EmployeeInfo;


/**
 * 数据生成
 */

public class DataUtils {
    public static List<String> getDataLists() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            list.add("测试数据" + i);
        }
        return list;
    }

    public static List<EmployeeInfo> getEmployees() {
        List<EmployeeInfo> list = new ArrayList<>();
        list.add(new EmployeeInfo("http://wmtp.net/wp-content/uploads/2016/07/1010689200fa918b241.jpg", "张三"));
        list.add(new EmployeeInfo("http://wmtp.net/wp-content/uploads/2016/07/1010689200fa918b241.jpg", "李四"));
        list.add(new EmployeeInfo("http://wmtp.net/wp-content/uploads/2016/07/1010689200fa918b241.jpg", "王五"));
        list.add(new EmployeeInfo("http://wmtp.net/wp-content/uploads/2016/07/1010689200fa918b241.jpg", "六娃"));
        list.add(new EmployeeInfo("http://wmtp.net/wp-content/uploads/2016/07/1010689200fa918b241.jpg", "毛二愣子"));
        list.add(new EmployeeInfo("http://wmtp.net/wp-content/uploads/2016/07/1010689200fa918b241.jpg", "小怪"));
        list.add(new EmployeeInfo("http://wmtp.net/wp-content/uploads/2016/07/1010689200fa918b241.jpg", "碗小二"));
        list.add(new EmployeeInfo("http://wmtp.net/wp-content/uploads/2016/07/1010689200fa918b241.jpg", "嘻哈组合"));
        list.add(new EmployeeInfo("http://wmtp.net/wp-content/uploads/2016/07/1010689200fa918b241.jpg", "小明"));
        return list;
    }
}
