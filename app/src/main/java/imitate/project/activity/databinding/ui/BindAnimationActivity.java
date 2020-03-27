package imitate.project.activity.databinding.ui;


import android.os.Bundle;

import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.OnRebindCallback;
import androidx.databinding.ViewDataBinding;
import imitate.project.R;
import imitate.project.base.BaseActivity;
import imitate.project.base.mvp.BasePresenter;
import imitate.project.databinding.ActivityBindAnimationBinding;


/**
 *  高级篇-动画
 */

public class BindAnimationActivity extends BaseActivity {
    ActivityBindAnimationBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_bind_animation);
        mBinding.setImageUrl("http://wmtp.net/wp-content/uploads/2016/07/1010689200fa918b241.jpg");
        mBinding.setPresenter(new Presenter());

        mBinding.addOnRebindCallback(new OnRebindCallback() {
            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                ViewGroup group = (ViewGroup) binding.getRoot();
                TransitionManager.beginDelayedTransition(group);
                return true;
            }
        });
    }

    public class Presenter {
        public void onCheckedChanged(View buttonView, boolean isChecked) {
            mBinding.setShowImage(isChecked);
        }
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bind_animation;
    }

    @Override
    protected void initData() {

    }

}
