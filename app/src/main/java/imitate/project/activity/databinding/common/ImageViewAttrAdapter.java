package imitate.project.activity.databinding.common;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.databinding.BindingAdapter;
import imitate.project.R;


/**
 * 图片加载
 */

public class ImageViewAttrAdapter {
    @BindingAdapter("resource")//    @BindingAdapter("bind:resource")
    public static void setImageResource(ImageView view, Bitmap bitmap) {
        view.setImageBitmap(bitmap);
    }

    @BindingAdapter("resourceID")
    public static void setImageResource(ImageView view, int resId) {
        view.setImageResource(resId);
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
