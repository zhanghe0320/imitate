package imitate.project.activity.myfirstcode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import imitate.project.R;
import imitate.project.activity.myfirstcode.msg.MessageActivity;
import me.jessyan.autosize.internal.CustomAdapt;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.hjq.toast.ToastUtils;

public class FirstActivity extends AppCompatActivity implements CustomAdapt {
    
    private static final String TAG = "FirstActivity";
    
    @BindView(R.id.opendialog)
    Button opendialog;
    @BindView(R.id.baidu)
    Button baidu;
    @BindView(R.id.openNomal)
    Button openNomal;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button_progress_bar)
    Button button_progress_bar;
    @BindView(R.id.button_message)
    Button button_message;
    
    @BindView(R.id.progress_bar)
    ProgressBar progress_bar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
        savedInstanceState = new Bundle();
        if (savedInstanceState != null) {
            String s = savedInstanceState.getString("firstdata");
            Log.d(TAG, "onCreate: " + s);
        } else {
            
        }
        savedInstanceState.putString("firstdata", "活动状态保存");
        
        // android.os.Process.killProcess(Process.myPid());//杀死进程
        
    }
    
    @OnClick({
            R.id.openNomal,
            R.id.opendialog,
            R.id.button2,
            R.id.baidu,
            R.id.button_progress_bar,
            R.id.button_message })
    public void onViewClicked(View view) {
        switch (view.getId()) {
        case R.id.openNomal:
            Intent intent = new Intent(FirstActivity.this, NormalActivity.class);
            // startActivityForResult(intent,1);
            startActivity(intent);
            break;
        case R.id.opendialog:
            intent = new Intent(FirstActivity.this, DialogActivity.class);
            // startActivityForResult(intent,1);
            startActivity(intent);
            break;
        case R.id.button2:
            String data = "FirstActivity跳转到SecondActivity";
            intent = new Intent(FirstActivity.this, SecondActivity.class);
            intent.putExtra("data", data);
            startActivityForResult(intent, 1);
            break;
        case R.id.baidu:
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.baidu.com"));
            // Intent intent= new Intent(Intent.ACTION_DIAL);
            // intent.setData(Uri.parse("tel:10086"));
            startActivity(intent);
            break;
        case R.id.button_progress_bar:
            if (progress_bar.getVisibility() == View.GONE) {
                progress_bar.setVisibility(View.VISIBLE);
            } else {
                progress_bar.setVisibility(View.GONE);
            }
            
            break;
        case R.id.button_message:
            MessageActivity.actionStart(FirstActivity.this);
            break;
        
        }
    }
    // @Override
    // public void onClick(View view) {
    // switch (view.getId()){
    // case R.id.openNomal:
    // Intent intent= new Intent(FirstActivity.this,NormalActivity.class);
    // // startActivityForResult(intent,1);
    // startActivity(intent);
    // break;
    // case R.id.opendialog:
    // intent= new Intent(FirstActivity.this,DialogActivity.class);
    // // startActivityForResult(intent,1);
    // startActivity(intent);
    // break;
    // case R.id.button2:
    // String data = "FirstActivity跳转到SecondActivity";
    // intent= new Intent(FirstActivity.this,SecondActivity.class);
    // intent.putExtra("data",data);
    // startActivityForResult(intent,1);
    // break;
    // case R.id.baidu:
    // intent= new Intent(Intent.ACTION_VIEW);
    // intent.setData(Uri.parse("https://www.baidu.com"));
    // // Intent intent= new Intent(Intent.ACTION_DIAL);
    // // intent.setData(Uri.parse("tel:10086"));
    // startActivity(intent);
    // break;
    //
    // }
    // }
    
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }
    
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
    
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        
        // super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: " + requestCode);
        
        switch (requestCode) {
        case 1:
            if (resultCode == RESULT_OK) {
                
                String mess = data.getStringExtra("data");
                Log.d(TAG, "onActivityResult: " + mess);
            }
            break;
        default:
            break;
        }
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
        case R.id.remove_item:
            
            ToastUtils.show("remove");
            Intent intent = new Intent("imitate.project..activity.myfirstcode.Action_start");
            startActivity(intent);
            break;
        case R.id.add_item:
            ToastUtils.show("add");
            
            intent = new Intent(FirstActivity.this, SecondActivity.class);
            startActivity(intent);
            break;
        }
        return true;
    }
    
    @Override
    public boolean isBaseOnWidth() {
        return true;
    }
    
    @Override
    public float getSizeInDp() {
        return 480;
    }
    
    // 用于启动activity
    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, FirstActivity.class);
        intent.putExtra("param1", data1);// 定义启动的必须参数
        intent.putExtra("param2", data2);// 定义启动的必须参数
        context.startActivity(intent);
    }
}
