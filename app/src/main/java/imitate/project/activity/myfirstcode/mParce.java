package imitate.project.activity.myfirstcode;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * android 数据序列化的使用
 * android Parcelable 序列化比 Serializable 效率高
 * 
 * 进行Android开发的时候，无法将对象的引用传给Activities或者Fragments，
 * 我们需要将这些对象放到一个Intent或者Bundle里面，然后再传递。
 * 简单来说就是将对象转换为可以传输的二进制流(二进制序列)的过程,
 * 这样我们就可以通过序列化,
 * 转化为可以在网络传输或者保存到本地的流(序列),
 * 从而进行传输数据,
 * 那反序列化就是从二进制流(序列)转化为对象的过程.
 */
public class mParce implements Parcelable {
    private String name;
    private Parcel dest;
    private int flags;
    
    protected mParce(Parcel in) {
        name = in.readString();
        flags = in.readInt();
    }
    
    public static final Creator<mParce> CREATOR = new Creator<mParce>() {
        @Override
        public mParce createFromParcel(Parcel in) {
            return new mParce(in);
        }
        
        @Override
        public mParce[] newArray(int size) {
            return new mParce[size];
        }
    };
    
    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(flags);
    }
    
}
