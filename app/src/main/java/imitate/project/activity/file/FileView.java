package imitate.project.activity.file;


import java.io.File;

import imitate.project.base.mvp.BaseView;

/**
 * File descripition:
 *
 * @author lp
 * @date 2019/8/6
 */
public interface FileView extends BaseView {
    void onFileSuccess(File file);
}
