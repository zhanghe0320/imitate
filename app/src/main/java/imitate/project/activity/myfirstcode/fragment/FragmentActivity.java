package imitate.project.activity.myfirstcode.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import imitate.project.R;

public class FragmentActivity extends AppCompatActivity implements View.OnClickListener {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.button:
            AnotherRightFragment fragment = new AnotherRightFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.right_layout, fragment);
            transaction.commit();

            //不是直接退出  点击返回的时候返回上一个fragment
            // AnotherRightFragment fragment = new AnotherRightFragment();
            //FragmentManager fragmentManager = getFragmentManager();
            //FragmentTransaction transaction = fragmentManager.beginTransaction();
            //transaction.replace(R.id.right_layout, fragment);
            //transaction.addToBackStack(null);//屏幕页面使用系统返回按钮的时候 返回的是上一个fragment  而不是直接退出页面
            //transaction.commit();
            break;
        default:
            break;
        }
    }
}
