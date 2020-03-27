package imitate.project.activity.databinding.model;

/**
 * Created by dengdayi
 * Date: 2017/03/10 14：05
 */

public class UserInfo {
    private String userName;
    private String mobile;
    private boolean isAdult;


    private Duty dutiy;

    public UserInfo() {
    }

    public UserInfo(String userName, String mobile) {
        this.userName = userName;
        this.mobile = mobile;
    }

    public UserInfo(String userName, String mobile, boolean isAdult) {
        this.userName = userName;
        this.mobile = mobile;
        this.isAdult = isAdult;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public Duty getDutiy() {
        return dutiy;
    }

    public void setDutiy(Duty dutiy) {
        this.dutiy = dutiy;
    }
}
