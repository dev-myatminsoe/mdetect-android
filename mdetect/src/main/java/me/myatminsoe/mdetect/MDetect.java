package me.myatminsoe.mdetect;

import android.graphics.Paint;

public class MDetect {

  /**
   * method for getting user's encoding
   *
   * @return whether user's encoding follows myanmar unicode standard
   */
  public static boolean isUnicode() {
    Paint paint = new Paint();
    return paint.measureText("\u1000\u1039\u1000")
        < paint.measureText("\u1000") + paint.measureText("\u1000") / 3;
  }
}
