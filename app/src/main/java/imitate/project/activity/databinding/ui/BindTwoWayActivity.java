package imitate.project.activity.databinding.ui;


import android.os.Bundle;
;
import android.text.Editable;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import imitate.project.R;
import imitate.project.activity.databinding.model.EmployeeInfo;
import imitate.project.activity.databinding.presenter.EditPresenter;
import imitate.project.base.BaseActivity;
import imitate.project.base.mvp.BasePresenter;
import imitate.project.commonutils.L;
import imitate.project.databinding.ActivityBindTwoWayBinding;


/**
 * 高级篇-双向绑定+表达式链+Lambda表达式
 */

public class BindTwoWayActivity extends BaseActivity {
    ActivityBindTwoWayBinding mBinding;
    EmployeeInfo employeeInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_bind_two_way);
        employeeInfo = new EmployeeInfo("http://wmtp.net/wp-content/uploads/2016/07/1010689200fa918b241.jpg", "张三");
        employeeInfo.setIsFired(true);
        mBinding.setEmployeeInfo(employeeInfo);
        setListener();
    }

    private void setListener() {
        mBinding.setEditPresenter(new EditPresenter() {
            @Override
            public void afterTextChanged(Editable s) {
                super.afterTextChanged(s);
                final String text = s.toString().trim();
                if (!text.equals(employeeInfo.getDesc().get())) {
                    employeeInfo.setDesc(text);
                }
            }
        });
        //model字段发生改变时调用
        employeeInfo.getDesc().addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                ObservableField<String> field = (ObservableField<String>) observable;
                L.i("field : " + field.get() + "  i : " + i);
            }
        });
    }


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bind_two_way;
    }

    @Override
    protected void initData() {

    }

}
