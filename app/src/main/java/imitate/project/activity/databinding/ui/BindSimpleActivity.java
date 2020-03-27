package imitate.project.activity.databinding.ui;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import imitate.project.R;
import imitate.project.activity.databinding.model.UserInfo;
import imitate.project.activity.databinding.presenter.SimplePresenter;
import imitate.project.activity.databinding.references.SimpleHandler;
import imitate.project.base.BaseActivity;
import imitate.project.base.mvp.BasePresenter;
import imitate.project.commonutils.L;
import imitate.project.databinding.ActivityBindSimpleBinding;


/**
 * DataBind简单布局
 *  DataBind创建+数据绑定+事件触发
 */

public class BindSimpleActivity extends BaseActivity {
    private UserInfo userInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBindSimpleBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_bind_simple);
        userInfo = new UserInfo("王小二", "13978574858");
        //两种方式等同
//        binding.setVariable(BR.user, userInfo);  //setVariable
        binding.setUser(userInfo);
        //事件绑定
        binding.setSimplePresenter(new SimplePresenter() {
            @Override
            public void onSaveClick(UserInfo user) {
                L.i("登录===" + user.getUserName() + "  ------- " + user.getMobile());
            }
        });

        binding.setSimpleHandler(new SimpleHandler() {
            @Override
            public void onClickFriend(View view) {
                L.i("注册===" + userInfo.getUserName() + "  ------- " + userInfo.getMobile());
            }
        });

        binding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L.i("点我");
            }
        });
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bind_simple;
    }

    @Override
    protected void initData() {

    }

}
