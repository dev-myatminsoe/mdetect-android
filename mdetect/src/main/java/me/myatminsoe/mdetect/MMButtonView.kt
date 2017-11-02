package me.myatminsoe.mdetect

import android.content.Context
import android.util.AttributeSet
import android.widget.Button

class MMButtonView : Button {

    constructor(context: Context) : super(context) {
        setMMText(text.toString())
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setMMText(text.toString())
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        setMMText(text.toString())
    }

    /**
     * method for setting text

     * @param unicodeString string in Myanmar Unicode
     */
    fun setMMText(unicodeString: String) {
        text = MDetect.getText(unicodeString)
    }

    /**
     * method for getting text
     * @return CharSequence in Myanmar Unicode
     */
    val mmText: String
        get() = MDetect.getText(text.toString())
}