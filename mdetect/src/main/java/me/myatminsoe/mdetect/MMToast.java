package me.myatminsoe.mdetect;

import android.content.Context;
import android.widget.Toast;

public class MMToast {

  public static Toast makeText(Context context, CharSequence message, int duration) {
    if (!MDetect.isUnicode()) message = Rabbit.uni2zg(message.toString());
    return Toast.makeText(context, message, duration);
  }

  public static Toast makeText(Context context, int resId, int duration) {
    String message = context.getResources().getString(resId);
    if (!MDetect.isUnicode()) message = Rabbit.uni2zg(message);
    return Toast.makeText(context, message, duration);
  }
}
