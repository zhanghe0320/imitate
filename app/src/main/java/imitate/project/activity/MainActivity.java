package imitate.project.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import imitate.project.R;
import imitate.project.activity.databinding.BindingActivity;
import imitate.project.activity.databinding.ui.Main2Activity;
import imitate.project.activity.file.FileActivity;
import imitate.project.activity.myfirstcode.FirstActivity;
import imitate.project.base.BaseActivity;
import imitate.project.base.BaseContent;
import imitate.project.base.mvp.BaseModel;
import imitate.project.bean.TextBean;
import imitate.project.commonutils.L;
import imitate.project.commonutils.RetrofitUtil;
import imitate.project.greendao.dao.Dao;
import imitate.project.greendao.utils.DbManager;
import retrofit2.http.HEAD;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView, View.OnClickListener {

    @BindView(R.id.tv_text) TextView mTvText;
    @BindView(R.id.btn_first)  Button  btn_first ;
    @BindView(R.id.btn_second) Button btn_second;
    @BindView(R.id.btn_second_2) Button btn_second_2;
    @BindView(R.id.btn_third) Button btn_third;
    @BindView(R.id.btn_forth) Button btn_forth;
    @BindView(R.id.btn_fifth) Button btn_fifth;
    @BindView(R.id.btn_six) Button btn_six;
    @BindView(R.id.btn_down) Button btn_down;
    @BindView(R.id.myother) Button myother;
    @BindView(R.id.listview) ListView listview;
    @BindView(R.id.dataBinding) Button dataBinding;
    @BindView(R.id.dataBinding2) Button dataBinding2;
    @BindView(R.id.myfirestcode) Button myfirestcode;

    //监听事件
    @OnClick({R.id.myother,R.id.btn_first,R.id.btn_second,R.id.btn_second_2,R.id.btn_third,R.id.btn_forth,R.id.btn_fifth,R.id.btn_six,R.id.btn_down,R.id.dataBinding,R.id.dataBinding2,R.id.myfirestcode})//多个控件可以一起发在里面进行监听
    public void onViewClicked(View v) {
        switch (v.getId()) {
            //默认请求
            case R.id.btn_first:
                mPresenter.getTextApi();
                break;
            //上传图片
            case R.id.btn_second:
                showToast("添加本地图片url,再进行测试");
//                upLoadImage();
                break;
            //上传文件进度测试
            case R.id.btn_second_2:
                mPresenter.upLoadVideoApi(BaseContent.baseFileName+"ceshi.mp4");
                break;
            //mvc测试
            case R.id.btn_third:
                startActivity(MvcActivity.class);
                break;
            //多基类测试
            case R.id.btn_forth:
                mPresenter.getTableListApi();
                break;
            //多基类测试
            case R.id.btn_fifth:
                mPresenter.getRestrictionsApi();
                break;
            //多基类测试
            case R.id.btn_six:
              //  mPresenter.getCheShiApi();
                mPresenter.getCheShiApi2();
                Dao dao = new Dao();
                dao.setName("ada");
                DbManager.getDaoSession(this).insertOrReplace(dao);
//                DbManager.getDaoSession(this).refresh(dao);
//                DbManager.getDaoSession(this).update(dao);
               // DbManager.getDaoSession(this).delete(dao);
               // DbManager.getDaoSession(this).deleteAll(dao.getClass());

                //DbManager.getDaoSession(this).getDaoDao().insert(dao);
                break;
            //文件上传测试
            case R.id.btn_down:
                startActivity(FileActivity.class);
                break;
            case R.id.myother://其他查询
                mPresenter.myother();
                break;
            case R.id.dataBinding://其他查询
                startActivity(BindingActivity.class);
            case R.id.dataBinding2://其他查询
                startActivity(Main2Activity.class);
                break;
            case R.id.myfirestcode://其他查询  启动activity 的方法
                FirstActivity.actionStart(MainActivity.this,"","");
                //startActivity(FirstActivity.class);
                break;


        }
    }


    private List<MainBean> mainBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( getLayoutId());
        ButterKnife.bind(this);
        initData();

    }


    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int getLayoutId() {

        return R.layout.activity_main;
    }


    @Override
    public void onErrorCode(BaseModel model) {
//        super.onErrorCode(model);
        //我要自定义
        //实现自己的逻辑
    }


    @Override
    public void showError(String msg) {
        if (msg.contains("重新登录")) {
//处理自己定制逻辑
        } else {
            super.showError(msg);
        }

    }


    @Override
    protected void initData() {
//        findViewById(R.id.btn_first).setOnClickListener(this);
//        findViewById(R.id.btn_second).setOnClickListener(this);
//        findViewById(R.id.btn_second_2).setOnClickListener(this);
//        findViewById(R.id.btn_third).setOnClickListener(this);
//        findViewById(R.id.btn_forth).setOnClickListener(this);
//        findViewById(R.id.btn_fifth).setOnClickListener(this);
//        findViewById(R.id.btn_six).setOnClickListener(this);
//        findViewById(R.id.btn_down).setOnClickListener(this);
//        mTvText = findViewById(R.id.tv_text);

        mainBeans = new ArrayList<>();


    }

    @Override
    public void onMainSuccess(BaseModel<List<MainBean>> o) {
        // 原文注销
//        Log.e(o.getErrmsg(), "");
//        Log.e(o.getErrcode() + "", "");
//        mainBeans.addAll(o.getData());
//        Log.e("sm", mainBeans.toString() + "");
//        mTvText.setText(o.getData().toString());
    }

    @Override
    public void onTextSuccess(BaseModel<TextBean> o) {
        mTvText.setText(o.getResult().getData().toString());
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            //默认请求
//            case R.id.btn_first:
//                mPresenter.getTextApi();
//                break;
//            //上传图片
//            case R.id.btn_second:
//                showToast("添加本地图片url,再进行测试");
//            // upLoadImage();
//                break;
//            //上传文件进度测试
//            case R.id.btn_second_2:
//                mPresenter.upLoadVideoApi(BaseContent.baseFileName+"ceshi.mp4");
//                break;
//            //mvc测试
//            case R.id.btn_third:
//                startActivity(MvcActivity.class);
//                break;
//            //多基类测试
//            case R.id.btn_forth:
//                mPresenter.getTableListApi();
//                break;
//            //多基类测试
//            case R.id.btn_fifth:
//                mPresenter.getRestrictionsApi();
//                break;
//            //多基类测试
//            case R.id.btn_six:
//                mPresenter.getCheShiApi();
//                break;
//            //文件上传测试
//            case R.id.btn_down:
//                startActivity(FileActivity.class);
//                break;
//        }
    }

    private void upLoadImage() {
        /**
         * 俩个参数  一个是图片集合路径   一个是和后台约定的Key，如果后台不需要，随便写都行
         */
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add("tupian.lujing");
        }
        mPresenter.upLoadImgApi(
                "title",
                "content",
                RetrofitUtil.filesToMultipartBodyParts(RetrofitUtil.initImages(strings), "tupian.key"));

    }

    @Override
    public void onUpLoadImgSuccess(BaseModel<Object> o) {
        L.e("文件视频路径==" + o.getResult());
    }

    /**
     * 测试多基类
     *
     * @param o
     */
    @Override
    public void onTableListSuccess(BaseModel<Object> o) {
        L.e("测试多基类1=" + o.getResult());
    }

    /**
     * 测试多基类
     *
     * @param o
     */
    @Override
    public void onRestrictionsSuccess(BaseModel<Object> o) {
        L.e("测试多基类2=" + o.getResult());
    }

    @Override
    public void onCheShiSuccess(BaseModel<Object> o) {
        L.e("测试多基类3=" + o.getResult());
    }




    @Override
    public void onMyOtherSuccess(BaseModel o) {
        mTvText.setText(o.toString());

    }
}
