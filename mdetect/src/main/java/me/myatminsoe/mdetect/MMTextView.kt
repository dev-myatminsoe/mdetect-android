package me.myatminsoe.mdetect

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import java.util.concurrent.Executor

class MMTextView : TextView {

  constructor(context: Context) : super(context) {
    setMMText(text.toString(), null)
  }

  constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    setMMText(text.toString(), null)
  }

  constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
    context,
    attrs,
    defStyle
  ) {
    setMMText(text.toString(), null)
  }

  /**
   * Convert the text to proper encoding method and set the text of the TextView
   *
   * @param unicodeString string in Myanmar Unicode
   * @param executor An Executor to do the converting process in the background
   * By default will use a default {@link JobExecutor} Implementation
   * Passing null will cause the conversion process to run in UI Thread, useful in cases where you
   * need immediate result such as RecyclerView items
   */
  fun setMMText(unicodeString: String, executor: Executor? = JobExecutor()) {
    if (executor == null) {
      text = MDetect.getText(unicodeString)
    } else {
      executor.execute {
        val convertedString = MDetect.getText(unicodeString)
        this.post {
          text = convertedString
        }
      }
    }
  }

  /**
   * method for getting text

   * @return CharSequence in Myanmar Unicode
   */
  val mmText: CharSequence
    get() = MDetect.getText(text.toString())
}
