package imitate.project.activity.file;



import java.io.File;

import imitate.project.api.ApiRetrofit;
import imitate.project.api.ApiServer;
import imitate.project.base.file.FileObserver;
import imitate.project.base.file.FileUtil;
import imitate.project.base.mvp.BasePresenter;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;

/**
 * File descripition:
 *
 * @author lp
 * @date 2019/8/6
 */
public class FilePresenter extends BasePresenter<FileView> {

    public FilePresenter(FileView baseView) {
        super(baseView);
    }

    public void downFile(String url, final String destFileDir, final String destFileName) {
        ApiServer apiServer = ApiRetrofit.getFileInstance(baseView).getApiService();
        Observable<String> observable = apiServer.downloadFile(url).map(new Function<ResponseBody, String>() {
            @Override
            public String apply(ResponseBody body) throws Exception {
                File file = FileUtil.saveFile(destFileDir+destFileName, body);
                return file.getPath();
            }
        });
        addFileDisposable(observable, new FileObserver(baseView) {
            @Override
            public void onSuccess(Object o) {
                baseView.onFileSuccess(new File(o.toString()));
            }

            @Override
            public void onError(String msg) {
                if (baseView != null) {
                    baseView.showError(msg);
                }
            }
        });
    }
}
