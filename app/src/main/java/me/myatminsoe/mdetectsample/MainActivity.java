package me.myatminsoe.mdetectsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import me.myatminsoe.mdetect.MDetect;
import me.myatminsoe.mdetect.MMToast;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Set Title MDetect example
    if (MDetect.isUnicode(this)) {
      setTitle("မြန်မာ");
    } else {
      setTitle("ျမန္မာ");
    }
  }

  public void showMyanmarToast(View v) {
    MMToast.makeText(this, R.string.hello, MMToast.LENGTH_SHORT).show();
  }
}
