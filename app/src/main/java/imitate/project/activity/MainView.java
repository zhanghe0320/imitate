package imitate.project.activity;




import java.util.List;

import imitate.project.base.mvp.BaseModel;
import imitate.project.base.mvp.BaseView;
import imitate.project.bean.TextBean;

/**
 * File descripition:
 *
 * @author lp
 * @date 2018/6/19
 */

public interface MainView extends BaseView {
    void onMainSuccess(BaseModel<List<MainBean>> o);
    void onTextSuccess(BaseModel<TextBean> o);

    void onUpLoadImgSuccess(BaseModel<Object> o);
    void onTableListSuccess(BaseModel<Object> o);
    void onRestrictionsSuccess(BaseModel<Object> o);
    void onCheShiSuccess(BaseModel<Object> o);



    void onMyOtherSuccess(BaseModel<Object>  o);

}
