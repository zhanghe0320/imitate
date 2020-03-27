package imitate.project.activity.databinding.model;

import android.graphics.drawable.Drawable;

/**
 * 用户职位
 */

public class Duty {
    private String name;
    private String introduction;
    private Drawable logo;
    private String imageUrl;

    public Duty(String name, String introduction, Drawable logo, String imageUrl) {
        this.name = name;
        this.introduction = introduction;
        this.logo = logo;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Drawable getLogo() {
        return logo;
    }

    public void setLogo(Drawable logo) {
        this.logo = logo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
