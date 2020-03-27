package imitate.project.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



import java.util.HashMap;

import imitate.project.R;
import imitate.project.api.ApiRetrofit;
import imitate.project.base.BaseActivity;
import imitate.project.base.mvp.BaseModel;
import imitate.project.base.mvp.BasePresenter;
import imitate.project.bean.TextBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * File descripition:   mvc演示
 *
 * @author lp
 * @date 2019/8/9
 */
public class MvcActivity extends BaseActivity implements View.OnClickListener {
    private TextView mTvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initData();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mTvText = findViewById(R.id.tv_text);
        findViewById(R.id.btn_first).setOnClickListener(this);
        findViewById(R.id.btn_second).setVisibility(View.GONE);
        findViewById(R.id.btn_second_2).setVisibility(View.GONE);
        findViewById(R.id.btn_third).setVisibility(View.GONE);
        findViewById(R.id.btn_forth).setVisibility(View.GONE);
        findViewById(R.id.btn_fifth).setVisibility(View.GONE);
        findViewById(R.id.btn_six).setVisibility(View.GONE);
        findViewById(R.id.btn_down).setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
       // getDataApi();
        getDataApi2();
    }

    @SuppressLint("CheckResult")
    private void getDataApi2() {
        //http://www.nj-lsj.net/Taste/mechineShelfList.do
        //  equipmentCode   201904190003000
        HashMap<String, String> params = new HashMap<>();
        params.put("equipmentCode", "201904190003000");
       // params.put("key", "2c1cb93f8c7430a754bc3ad62e0fac06");
        ApiRetrofit.getBaseUrlInstance("http://www.nj-lsj.net/Taste/").getApiService()
                .getText(params)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<BaseModel<TextBean>, BaseModel<TextBean>>() {
                    @Override
                    public BaseModel<TextBean> apply(BaseModel<TextBean> objectBaseModel) throws Exception {
                        return objectBaseModel;
                    }
                }).subscribe(new Consumer<BaseModel<TextBean>>() {
            @Override
            public void accept(BaseModel<TextBean> o) throws Exception {
                mTvText.setText(o.getResult().getData().toString());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                throwable.printStackTrace();
            }
        });
    }
    @SuppressLint("CheckResult")
    private void getDataApi() {
        HashMap<String, String> params = new HashMap<>();
        params.put("type", "junshi");
        params.put("key", "2c1cb93f8c7430a754bc3ad62e0fac06");
        ApiRetrofit.getInstance().getApiService()
                .getText(params)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<BaseModel<TextBean>, BaseModel<TextBean>>() {
                    @Override
                    public BaseModel<TextBean> apply(BaseModel<TextBean> objectBaseModel) throws Exception {
                        return objectBaseModel;
                    }
                }).subscribe(new Consumer<BaseModel<TextBean>>() {
            @Override
            public void accept(BaseModel<TextBean> o) throws Exception {
                mTvText.setText(o.getResult().getData().toString());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                throwable.printStackTrace();
            }
        });
    }
}
