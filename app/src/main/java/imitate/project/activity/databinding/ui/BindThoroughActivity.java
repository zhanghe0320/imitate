package imitate.project.activity.databinding.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import imitate.project.R;
import imitate.project.activity.databinding.model.Duty;
import imitate.project.activity.databinding.model.UserInfo;
import imitate.project.base.BaseActivity;
import imitate.project.base.mvp.BasePresenter;
import imitate.project.databinding.ActivityBindThoroughBinding;


/**
 * DataBind深入布局
 * 入门篇-表达式+null检查+include
 */

public class BindThoroughActivity extends BaseActivity {
    ActivityBindThoroughBinding binding;
    private UserInfo userInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bind_thorough);
        userInfo = new UserInfo("王小二", "13978574858", false);

        Drawable drawable = getResources().getDrawable(R.mipmap.icon_group_conversation_logo);
        Duty duty = new Duty("Android程序员", "手机软件开发", drawable, "http://wmtp.net/wp-content/uploads/2016/07/1010689200fa918b241.jpg");
        userInfo.setDutiy(duty);

        binding.setUserInfo(userInfo);
        //设置点击事件
        binding.setOnClickMeListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean bool = !userInfo.isAdult();
                userInfo.setAdult(bool);
                //这里是单向绑定， 后续有双向绑定的代码
                binding.tvShowView.setVisibility(bool ? View.VISIBLE : View.GONE);
            }
        });
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bind_thorough;
    }

    @Override
    protected void initData() {

    }

}
