package me.myatminsoe.mdetect

import android.content.Context
import android.graphics.Canvas
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

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
    }

    /**
     * method for setting text

     * @param unicodeString string in Myanmar Unicode
     */
    fun setMMText(unicodeString: String) {
        if (MDetect.isUnicode()) {
            text = unicodeString
        } else {
            text = Rabbit.uni2zg(unicodeString)
        }
    }

    /**
     * method for getting text

     * @return CharSequence in Myanmar Unicode
     */
    val mmText: CharSequence
        get() = if (MDetect.isUnicode()) text else Rabbit.zg2uni(text.toString())
}