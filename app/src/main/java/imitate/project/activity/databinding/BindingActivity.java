package imitate.project.activity.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 3fef1f0... 增加说明
=======

>>>>>>> 9e27b5b... 增加说明
import imitate.project.R;
import imitate.project.base.BaseActivity;
import imitate.project.base.mvp.BasePresenter;
import imitate.project.databinding.ActivityBindingBinding;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BindingActivity extends BaseActivity implements View.OnClickListener {

    private User user;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 9e27b5b... 增加说明
//    @BindView(R.id.name) EditText name;
//    @BindView(R.id.age)EditText age;
//    @BindView(R.id.password) EditText password;
//    @BindView(R.id.sex)EditText sex;
<<<<<<< HEAD

//    lambda表达式通用格式：(args)->{body}，则lambda表达式由三部分组成：
//       1.(arg1,arg2...) 参数部分
//      2.-> goes to符号
//      3. {} 方法代码块
ActivityBindingBinding activityBindingBinding;
=======
    @BindView(R.id.name) EditText name;
    @BindView(R.id.age)EditText age;
    @BindView(R.id.password) EditText password;
    @BindView(R.id.sex)EditText sex;
=======
>>>>>>> 9e27b5b... 增加说明

<<<<<<< HEAD

>>>>>>> 3fef1f0... 增加说明
=======
//    lambda表达式通用格式：(args)->{body}，则lambda表达式由三部分组成：
//       1.(arg1,arg2...) 参数部分
//      2.-> goes to符号
//      3. {} 方法代码块
<<<<<<< HEAD
>>>>>>> 6b88e5c... 增加说明
=======
ActivityBindingBinding activityBindingBinding;
>>>>>>> 9e27b5b... 增加说明
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binding);

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        activityBindingBinding = DataBindingUtil.setContentView(this,R.layout.activity_binding);
        ButterKnife.bind(this);
        user = new User("阿达的","20","hsdajk","男");
        user.setAge0(200);
        activityBindingBinding.setUser(user);//绑定数据
        activityBindingBinding.setHandler(new MyHandlers());//绑定事件
        activityBindingBinding.name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
=======
=======

>>>>>>> 6b88e5c... 增加说明
        ActivityBindingBinding activityBindingBinding = DataBindingUtil.setContentView(this,R.layout.activity_binding);
=======
        activityBindingBinding = DataBindingUtil.setContentView(this,R.layout.activity_binding);
>>>>>>> 9e27b5b... 增加说明
        ButterKnife.bind(this);
        user = new User("阿达的","20","hsdajk","男");
        user.setAge0(200);
        activityBindingBinding.setUser(user);//绑定数据
        activityBindingBinding.setHandler(new MyHandlers());//绑定事件
<<<<<<< HEAD
        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
>>>>>>> 3fef1f0... 增加说明
=======
        activityBindingBinding.name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
>>>>>>> 9e27b5b... 增加说明
            @Override
            public void onFocusChange(View view, boolean b) {
                Log.i(TAG, "onFocusChange: "+user.toString());
            }
        });
<<<<<<< HEAD
<<<<<<< HEAD

        activityBindingBinding.name.setOnClickListener(new View.OnClickListener() {
=======

<<<<<<< HEAD
        name.setOnClickListener(new View.OnClickListener() {
>>>>>>> 6b88e5c... 增加说明
=======
        activityBindingBinding.name.setOnClickListener(new View.OnClickListener() {
>>>>>>> 9e27b5b... 增加说明
            @Override
            public void onClick(View view) {

            }
        });

<<<<<<< HEAD
<<<<<<< HEAD
        activityBindingBinding.name.setOnClickListener((View v)->{
=======
        name.setOnClickListener((View v)->{
>>>>>>> 6b88e5c... 增加说明
=======
        activityBindingBinding.name.setOnClickListener((View v)->{
>>>>>>> 9e27b5b... 增加说明
            Log.i(TAG, "onFocusChange: "+user.toString());
        });
        Thread gaoDuanDaQiShangDangCi = new Thread( () -> {
            System.out.println("This is from an anonymous method (lambda exp).");
        } );

<<<<<<< HEAD
=======
>>>>>>> 3fef1f0... 增加说明
=======
>>>>>>> 6b88e5c... 增加说明
    }

    public class MyHandlers {
        public void onClickView(View view){
<<<<<<< HEAD
<<<<<<< HEAD
            int a = activityBindingBinding.textview.getId();
            int b =R.id.textview;
            Log.i(TAG, "onClickView: "+a+"--"+b);
=======
>>>>>>> 3fef1f0... 增加说明
=======
            int a = activityBindingBinding.textview.getId();
            int b =R.id.textview;
            Log.i(TAG, "onClickView: "+a+"--"+b);
>>>>>>> 9e27b5b... 增加说明
            switch (view.getId()){
                case R.id.textview:
                    Toast.makeText(view.getContext(), "textview绑定事件成功", Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "onClickView:"+user.toString());
                    break;
                case R.id.button:
                    Toast.makeText(view.getContext(), "button绑定事件成功", Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "onClickView:"+user.toString());
                    break;
            }
        };
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_binding;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        // getDataApi();
    }
}
