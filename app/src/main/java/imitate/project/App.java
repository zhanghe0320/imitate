package imitate.project;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;

import com.hjq.toast.ToastUtils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.squareup.leakcanary.LeakCanary;

import java.util.ArrayList;

import androidx.multidex.MultiDexApplication;
import imitate.project.activity.MainActivity;
import imitate.project.crash.CaocConfig;

/**
 * File descripition:   运用此项目时，修改地方如下
 * <p>
 * 1.BaseContent 中 baseUrl修改
 * 2.BaseContent 中 basecode修改
 * 3.BaseModel 中 各字段参数名 修改为接口对应
 * 备注：(接口如果复杂，自己修改不了，可以联系我)
 *
 *
 * @author lp
 * @date 2018/10/11
 */

public class App extends MultiDexApplication {
    private static Context mContext;
    private static ArrayList<Activity> activities = new ArrayList<Activity>();
    private String name;

    @Override
    public void onCreate() {
        super.onCreate();

        // 在 Application 中初始化
        ToastUtils.init(this);

        mContext = this;
        initLogger();

<<<<<<< HEAD
<<<<<<< HEAD
        //错误异常捕捉
=======
>>>>>>> 3fef1f0... 增加说明
=======
        //错误异常捕捉
>>>>>>> 9e27b5b... 增加说明
        initCrash();
        //内存泄漏检测  //去除leak内存泄漏检测
        if (!LeakCanary.isInAnalyzerProcess(this)) {
            LeakCanary.install(this);
        }
    }

    private void initCrash() {
        CaocConfig.Builder.create()
                .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT) //背景模式,开启沉浸式
                .enabled(true) //是否启动全局异常捕获
                .showErrorDetails(true) //是否显示错误详细信息
                .showRestartButton(true) //是否显示重启按钮
                .trackActivities(true) //是否跟踪Activity
                .minTimeBetweenCrashesMs(2000) //崩溃的间隔时间(毫秒)
                .errorDrawable(R.mipmap.ic_launcher) //错误图标
                .restartActivity(MainActivity.class) //重新启动后的activity
//                .errorActivity(YourCustomErrorActivity.class) //崩溃后的错误activity
//                .eventListener(new YourCustomEventListener()) //崩溃后的错误监听
                .apply();
    }
    public static Context getContext() {
        return mContext;
    }

    private void initLogger() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // 是否显示线程信息 默认显示 上图Thread Infrom的位置
                .methodCount(0)         // 展示方法的行数 默认是2  上图Method的行数
                .methodOffset(7)        // 内部方法调用向上偏移的行数 默认是0
//                .logStrategy(customLog) // 改变log打印的策略一种是写本地，一种是logcat显示 默认是后者（当然也可以自己定义）
                .tag("mvp_network_tag")   // 自定义全局tag 默认：PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return true;
            }
        });
    }




    /*
     * 当操作系统确定是进程从其进程中删除不需要的内存的好时机时调用;
     * 例如，当它进入后台并且没有足够的内存来保持尽可能多的后台进程运行时，就会发生这种情况;
     * 通常比较该值是否大于或等于
     */
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        switch (level) {
            case TRIM_MEMORY_UI_HIDDEN:
                break;
        }
    }

    /*
     *当组件运行时，设备配置发生变化时由系统调用，如：屏幕旋转，通过重新检索资源
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

    /*
     *当整个系统内存不足时调用此方法，也可采用手动方式重写此方法来清空缓存或者释放不必要的资源
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    /*
     * 应用程序结束时调用，
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    /*
     * 关闭Application finish activity 并释放内存；
     */
    public static void exitApp() {
        for (Activity acti : activities) {
            acti.finish();
        }
        System.exit(0);
    }

    /*
     *添加相应的activity
     */
    public static void addActivity(Activity acti) {
        activities.add(acti);
    }

    /*
     *finish相应的activity
     */
    public static void removeActivity(Activity acti) {
        int index = -1;
        if ((index = activities.indexOf(acti)) != -1) {
            activities.remove(index).finish();
        }
    }


    protected void setName(String name) {
        this.name = name;
    }

    protected String getName() {
        return name;
    }



//    @Override
//    protected void attachBaseContext(Context base) {  //或者使用这种方法解决引用方法限制的问题
//        super.attachBaseContext(base);
//        MultiDex.install(this);
//
//    }
}
