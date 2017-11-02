package me.myatminsoe.mdetectsample

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import me.myatminsoe.mdetect.MDetect
import me.myatminsoe.mdetect.MMButtonView
import me.myatminsoe.mdetect.MMTextView
import me.myatminsoe.mdetect.MMToast

class MainActivity : AppCompatActivity() {

    private val items = arrayOf("ဧရာဝတီတိုင်းဒေသကြီး","ပဲခူးတိုင်းဒေသကြီး","ချင်းပြည်နယ်","ကချင်ပြည်နယ်","ကယားပြည်နယ်","ကရင်ပြည်နယ်","မကွေးတိုင်းဒေသကြီး","မန္တလေးတိုင်းဒေသကြီး","မွန်ပြည်နယ်","ရခိုင်ပြည်နယ်","ရှမ်းပြည်နယ်","စစ်ကိုင်းတိုင်းဒေသကြီး","တနင်္သာရီတိုင်းဒေသကြီး","ရန်ကုန်တိုင်းဒေသကြီး","နေပြည်တော် ပြည်ထောင်စုနယ်မြေ")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById(R.id.tv_main) as MMTextView

        title = MDetect.getText("မြန်မာ")

        if (MDetect.isUnicode()) {
            tv.text = "ယူနီကုဒ်စနစ်ကိုအသုံးပြုထားပါသည်။"
            tv.setTextColor(resources.getColor(R.color.green_500))
        } else {
            tv.text = "ေဇာ္ဂ်ီစနစ္ကိုအသံုးျပဳထားပါသည္။"
            tv.setTextColor(resources.getColor(R.color.red_500))
        }

    }

    fun divisions(v: View) {
        val builder = AlertDialog.Builder(this)
        builder.setItems(MDetect.getStringArray(items)) { dialog, which ->
            (v as MMButtonView).setMMText(items[which])
        }.show()
    }

    fun showMyanmarToast(v: View) {
        MMToast.showShortToast(this, "မင်္ဂလာပါ")
    }
}
