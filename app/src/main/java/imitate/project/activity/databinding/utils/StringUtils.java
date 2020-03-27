package imitate.project.activity.databinding.utils;

import android.text.TextUtils;

/**
 */

public class StringUtils {
    public static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return "你的值是null";
        } else {
            return "验证通过了";
        }
    }
}
