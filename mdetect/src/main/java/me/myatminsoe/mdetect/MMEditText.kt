package me.myatminsoe.mdetect

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText

class MMEditText : EditText {

    constructor(context: Context) : super(context) {
        if (hint != null) {
            hint = MDetect.getText(hint.toString())
        }
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        if (hint != null) {
            hint = MDetect.getText(hint.toString())
        }
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        if (hint != null) {
            hint = MDetect.getText(hint.toString())
        }
    }

    /**
     * method for setting text

     * @param unicodeString string in Myanmar Unicode
     */
    fun setMMText(unicodeString: String) {
        setText(MDetect.getText(unicodeString))
    }

    /**
     * method for getting text

     * @return CharSequence in Myanmar Unicode
     */
    val mmText: CharSequence
        get() = MDetect.getText(text.toString())
}
