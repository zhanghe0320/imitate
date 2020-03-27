package imitate.project.activity.databinding.ui;

import imitate.project.R;
import imitate.project.base.BaseActivity;
import imitate.project.base.mvp.BasePresenter;

import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;

public class Main2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    /**
     * DataBind创建+数据绑定+事件触发
     *
     * @param view
     */
    public void onDataBindSimple(View view) {
        ActivityUtils.startActivity(this, BindSimpleActivity.class);
    }

    /**
     * 入门篇-表达式+null检查+include
     *
     * @param view
     */
    public void onDataBindThorough(View view) {
        ActivityUtils.startActivity(this, BindThoroughActivity.class);
    }

    /**
     * 入门篇-observable对象
     *
     * @param view
     */
    public void onDataObservable(View view) {
        ActivityUtils.startActivity(this, BindObservableActivity.class);
    }

    /**
     * 入门篇-列表绑定+自定义属性
     *
     * @param view
     */
    public void onDataBindSenior(View view) {
        ActivityUtils.startActivity(this, BindSeniorActivity.class);
    }

    /**
     * 高级篇-双向绑定+表达式链
     *
     * @param view
     */
    public void onDataBindTwoWay(View view) {
        ActivityUtils.startActivity(this, BindTwoWayActivity.class);
    }

    /**
     * 高级篇-Lambda表达式
     * @param view
     */
    public void onDatBindLambda(View view) {
        ActivityUtils.startActivity(this, BindLambdaActivity.class);
    }
    /**
     * 高级篇-动画
     * @param view
     */
    public void onDatBindAnimation(View view) {
        ActivityUtils.startActivity(this, BindAnimationActivity.class);
    }



    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initData() {

    }

}
