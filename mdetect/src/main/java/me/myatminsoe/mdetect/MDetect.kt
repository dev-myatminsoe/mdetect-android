package me.myatminsoe.mdetect

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView

object MDetect {

    private val TYPE_UNICODE = 0
    private val TYPE_ZAWGYI = 1
    private val TYPE_DEFAULT = 2

    private var isUnicode = TYPE_DEFAULT

    fun init(context: Context) {
        if (isUnicode != TYPE_DEFAULT)
            return
        val tv = TextView(context, null)
        tv.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)

        tv.text = "\u1000"
        tv.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val length1 = tv.measuredWidth

        tv.text = "\u1000\u1039\u1000"
        tv.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val length2 = tv.measuredWidth

        Log.i("MDetect", length1.toString() + ", " + length2)

        isUnicode = if (length1 == length2) TYPE_UNICODE else TYPE_ZAWGYI
    }

    /**
     * method for getting user's encoding

     * @return whether user's encoding follows myanmar unicode standard
     */
    fun isUnicode(): Boolean {
        if (isUnicode == TYPE_DEFAULT)
            throw UnsupportedOperationException("MDetect was not initialized.")
        return isUnicode == TYPE_UNICODE
    }

    fun getString(unicodeString: String): String {
        if (isUnicode())
            return unicodeString
        return Rabbit.uni2zg(unicodeString)
    }

    fun getStringArray(unicodeStringArray: Array<String>): Array<String> {
        if (isUnicode())
            return unicodeStringArray
        for (i in unicodeStringArray.indices) {
            unicodeStringArray[i] = Rabbit.uni2zg(unicodeStringArray[i])
        }
        return unicodeStringArray
    }
}
