package me.myatminsoe.mdetect;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

public class MDetect {

    private static final int TYPE_UNICODE = 0;
    private static final int TYPE_ZAWGYI = 1;
    private static final int TYPE_DEFAULT = 3;

    private static int isUnicode = TYPE_DEFAULT;

    private MDetect() {}

    /**
     * method for getting user's encoding
     * @param context Context
     * @return whether user's encoding follows myanmar unicode standard
     */
    public static boolean isUnicode(Context context) {
        if (isUnicode == TYPE_DEFAULT) {
            isUnicode = getType(context);
        }
        return isUnicode == TYPE_UNICODE;
    }

    private static int getType(Context context) {
        TextView tv = new TextView(context, null);
        tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        tv.setText("\u1000");
        tv.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int i1 = tv.getMeasuredWidth();

        tv.setText("\u1000\u1039\u1000");
        tv.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int i2 = tv.getMeasuredWidth();

        Log.i("MDetect", i1 + ", " + i2);

        return i1 == i2 ? TYPE_UNICODE : TYPE_ZAWGYI;
    }
}
