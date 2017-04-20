package me.myatminsoe.mdetect;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

public class MDetect {

    private static final int TYPE_UNICODE = 0;
    private static final int TYPE_ZAWGYI = 1;
    private static final int TYPE_DEFAULT = 2;

    private static int isUnicode = TYPE_DEFAULT;

    private MDetect() {
    }

    public static void init(Context context) {
        if(isUnicode != TYPE_DEFAULT)
            return;
        TextView tv = new TextView(context, null);
        tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        tv.setText("\u1000");
        tv.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int length1 = tv.getMeasuredWidth();

        tv.setText("\u1000\u1039\u1000");
        tv.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int length2 = tv.getMeasuredWidth();

        Log.i("MDetect", length1 + ", " + length2);

        isUnicode = length1 == length2 ? TYPE_UNICODE : TYPE_ZAWGYI;
    }

    /**
     * method for getting user's encoding
     *
     * @return whether user's encoding follows myanmar unicode standard
     */
    public static boolean isUnicode() {
        if (isUnicode == TYPE_DEFAULT)
            throw new UnsupportedOperationException("MDetect was not initialized.");
        return isUnicode == TYPE_UNICODE;
    }

    public static String getString(String unicodeString) {
        if (isUnicode())
            return unicodeString;
        return Rabbit.uni2zg(unicodeString);
    }

    public static String[] getStringArray(String[] unicodeStringArray) {
        if (isUnicode())
            return unicodeStringArray;
        for (int i = 0; i < unicodeStringArray.length; i++) {
            unicodeStringArray[i] = Rabbit.uni2zg(unicodeStringArray[i]);
        }
        return unicodeStringArray;
    }
}
