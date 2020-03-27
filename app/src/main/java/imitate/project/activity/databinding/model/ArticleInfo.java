package imitate.project.activity.databinding.model;


import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

/**
 */

public class ArticleInfo {
    private ObservableField<String> title = new ObservableField<>();
    private ObservableField<String> desc = new ObservableField<>();
    private ObservableInt readCount = new ObservableInt();

    public ObservableField<String> getTitle() {
        return title;
    }

    public void setTitle(ObservableField<String> title) {
        this.title = title;
    }

    public ObservableField<String> getDesc() {
        return desc;
    }

    public void setDesc(ObservableField<String> desc) {
        this.desc = desc;
    }

    public ObservableInt getReadCount() {
        return readCount;
    }

    public void setReadCount(ObservableInt readCount) {
        this.readCount = readCount;
    }
}
