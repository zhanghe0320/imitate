package imitate.project.activity.myfirstcode.msg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import imitate.project.R;

public class MessageActivity extends AppCompatActivity {
    private ListView msgListView;
    private EditText inputText;
    private Button send;
    private MsgAdapter adapter;
    private List<Msg> msgList = new ArrayList<Msg>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_message);
        initMsgs(); // 初始化消息数据
        adapter = new MsgAdapter(MessageActivity.this, R.layout.msg_item, msgList);
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgListView = (ListView) findViewById(R.id.msg_list_view);
        msgListView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyDataSetChanged(); // 当有新消息时，刷新 ListView中的显示
                    msgListView.setSelection(msgList.size()); // 将ListView 定位到最后一行
                    inputText.setText(""); // 清空输入框中的内容
                }
            }
        });
    }
    
    private void initMsgs() {
        Msg msg1 = new Msg("Hello guy.", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("Hello. Who is that?", Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("ThisisTom.Nicetalkingtoyou.", Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }
    
    // 用于启动activity
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MessageActivity.class);
        // intent.putExtra("param1", data1);//定义启动的必须参数
        // intent.putExtra("param2", data2);//定义启动的必须参数
        context.startActivity(intent);
    }
}
