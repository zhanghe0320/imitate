package imitate.project.activity.myfirstcode;

import androidx.appcompat.app.AppCompatActivity;
import imitate.project.R;
import me.jessyan.autosize.internal.CustomAdapt;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity implements CustomAdapt {
    private static final String TAG = "SecondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent= getIntent();
       String date =  intent.getStringExtra("data");
        Log.e(TAG, "onCreate: "+date );
        findViewById(R.id.seconeback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent();
                intent1.putExtra("data","从第二个页面返回到第一个页面携带的信息");
                setResult(RESULT_OK,intent1);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {//自带返回键返回
        Intent intent1 = new Intent();
        intent1.putExtra("data","从第二个页面返回到第一个页面携带的信息");
        setResult(RESULT_OK,intent1);
        finish();
       // super.onBackPressed();
    }

    @Override
    public boolean isBaseOnWidth() {
        return true;
    }

    @Override
    public float getSizeInDp() {
        return 480;
    }
}
