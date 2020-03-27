package imitate.project.activity.databinding.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.hjq.toast.ToastUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import imitate.project.R;
import imitate.project.activity.databinding.model.EmployeeInfo;
import imitate.project.base.BaseActivity;
import imitate.project.base.mvp.BasePresenter;
import imitate.project.commonutils.L;
import imitate.project.databinding.ActivityBindLambdaBinding;


/**
 * 高级篇-Lambda表达式
 */

public class BindLambdaActivity extends BaseActivity {
    ActivityBindLambdaBinding mBinding;
    EmployeeInfo employeeInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_bind_lambda);
        employeeInfo = new EmployeeInfo("http://wmtp.net/wp-content/uploads/2016/07/1010689200fa918b241.jpg", "张三");
        mBinding.setEmployeeInfo(employeeInfo);
        mBinding.setPresenter(new Presenter());
    }

    public class Presenter {
        public void NonEmployeeClick(EmployeeInfo info) {
            L.i("onEmployeeClick info : " + info.toString());
        }

        public void onEmployeeLongClick(EmployeeInfo info, Context context) {
            ToastUtils.show( "onEmployeeLongClick info : " + info.toString());
        }

//        public void onFocusChanged(EmployeeInfo info) {
//        }
    }


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bind_lambda;
    }

    @Override
    protected void initData() {

    }

}
