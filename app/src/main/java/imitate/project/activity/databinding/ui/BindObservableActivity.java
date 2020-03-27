package imitate.project.activity.databinding.ui;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import imitate.project.R;
import imitate.project.activity.databinding.model.ArticleInfo;
import imitate.project.activity.databinding.model.ObservableUser;
import imitate.project.activity.databinding.presenter.EditPresenter;
import imitate.project.base.BaseActivity;
import imitate.project.base.mvp.BasePresenter;
import imitate.project.commonutils.L;
import imitate.project.databinding.ActivityBindObservableBinding;


/**
 * 入门篇-observable对象
 */

public class BindObservableActivity extends BaseActivity {
    private ActivityBindObservableBinding binding;
    private ObservableUser user;
    private ArticleInfo articleInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bind_observable);
        user = new ObservableUser("王", "晓儿");
        binding.setUser(user);

        articleInfo = new ArticleInfo();
        articleInfo.setTitle(new ObservableField<>("测试"));
        articleInfo.setDesc(new ObservableField<>("描述"));
        articleInfo.setReadCount(new ObservableInt(10));
        binding.setArticleInfo(articleInfo);
        setListener();
    }

    private void setListener() {
        binding.setOnOtherNameClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L.i("user.getFirstName() : " + user.getFirstName() + "\nuser.getLastName() : " + user.getLastName());
            }
        });
        binding.setOnOtherNameSecondClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L.i(
                        "标题： " + binding.getArticleInfo().getTitle().get()
                                + "\n描述 : " + binding.getArticleInfo().getDesc().get()
                                + "\n阅读数量： " + binding.getArticleInfo().getReadCount().get());
            }
        });
        binding.setEditPresenter(new EditPresenter() {
            @Override
            public void afterTextChanged(Editable s) {
                super.afterTextChanged(s);
                user.setFirstName(s.toString());
            }
        });
    }


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bind_observable;
    }

    @Override
    protected void initData() {

    }

}
