package me.myatminsoe.mdetectsample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import me.myatminsoe.mdetect.MMTextView

class LargeTextActivity : AppCompatActivity() {

  companion object {

    private const val IE_ENABLE_BACKGROUND_CONVERT = "IE_ENABLE_BACKGROUND_CONVERT"

    fun newIntent(context: Context, enableBackgroundConvert: Boolean): Intent {
      val intent = Intent(context, LargeTextActivity::class.java)
      intent.putExtra(IE_ENABLE_BACKGROUND_CONVERT, enableBackgroundConvert)
      return intent
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_large_text)

    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    val enableBackgroundConvert = intent.getBooleanExtra(IE_ENABLE_BACKGROUND_CONVERT, true)

    val textView = findViewById<MMTextView>(R.id.tvLargeText)
    val string = getString(R.string.large_text)
    if (enableBackgroundConvert) {
      textView.setMMText(string)
    } else {
      textView.setMMText(string, null)
    }

  }
}

