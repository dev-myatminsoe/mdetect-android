package me.myatminsoe.mdetectsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import me.myatminsoe.mdetect.MDetect
import me.myatminsoe.mdetect.MMTextView
import me.myatminsoe.mdetect.MMToast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById(R.id.tv_main) as MMTextView
        title = MDetect.getString("မြန်မာ")

        if (MDetect.isUnicode()) {
            tv.text = "ယူနီကုဒ်စနစ်ကိုအသုံးပြုထားပါသည်။"
            tv.setTextColor(resources.getColor(R.color.green_500))
        } else {
            tv.text = "ေဇာ္ဂ်ီစနစ္ကိုအသံုးျပဳထားပါသည္။"
            tv.setTextColor(resources.getColor(R.color.red_500))
        }
    }

    fun showMyanmarToast(v: View) {
        MMToast.makeText(this, R.string.hello, MMToast.LENGTH_SHORT).show()
    }
}
