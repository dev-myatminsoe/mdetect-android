package me.myatminsoe.mdetect

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText

class MMEditText : EditText {

    constructor(context: Context) : super(context) {

        if (hint != null) {
            if (MDetect.isUnicode()) {
                hint = hint
            } else {
                hint = Rabbit.uni2zg(hint.toString())
            }
        }
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        if (hint != null) {
            if (MDetect.isUnicode()) {
                hint = hint
            } else {
                hint = Rabbit.uni2zg(hint.toString())
            }
        }
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        if (hint != null) {
            if (MDetect.isUnicode()) {
                hint = hint
            } else {
                hint = Rabbit.uni2zg(hint.toString())
            }
        }
    }

    /**
     * method for setting text

     * @param unicodeString string in Myanmar Unicode
     */
    fun setMMText(unicodeString: String) {
        if (MDetect.isUnicode()) {
            setText(unicodeString)
        } else {
            setText(Rabbit.uni2zg(unicodeString))
        }
    }

    /**
     * method for getting text

     * @return CharSequence in Myanmar Unicode
     */
    val mmText: CharSequence
        get() = if (MDetect.isUnicode()) text else Rabbit.zg2uni(text.toString())
}
