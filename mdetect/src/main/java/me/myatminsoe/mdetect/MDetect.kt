package me.myatminsoe.mdetect

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView

object MDetect {

    private val TYPE_DEFAULT = 0
    private val TYPE_UNICODE = 1
    private val TYPE_ZAWGYI = 2

    private var isUnicode = TYPE_DEFAULT

    fun init(context: Context) {
        if (isUnicode != TYPE_DEFAULT) {
            Log.i("MDetect", "MDetect was already initialized.")
            return
        }
        val textView = TextView(context, null)
        textView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)

        textView.text = "\u1000"
        textView.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val length1 = textView.measuredWidth

        textView.text = "\u1000\u1039\u1000"
        textView.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val length2 = textView.measuredWidth

        Log.i("MDetect", length1.toString() + ", " + length2)

        isUnicode = if (length1 == length2) TYPE_UNICODE else TYPE_ZAWGYI
    }

    /**
     * method for getting user's encoding

     * @return whether the device follows myanmar unicode standard
     */
    fun isUnicode(): Boolean {
        if (isUnicode == TYPE_DEFAULT)
            throw UnsupportedOperationException("MDetect was not initialized.")
        return isUnicode == TYPE_UNICODE
    }

    /**
     * method for getting display text
     * @param unicodeString Unicode String
     * @return appropriate String according to device's encoding
     */
    fun getText(unicodeString: String): String {
        return if (isUnicode()) unicodeString else Rabbit.uni2zg(unicodeString)
    }

    /**
     * method for getting String from user input
     * @param inputString String inputted by user
     * @return Unicode String
     */
    fun getInputString(inputString: String): String {
        return if (isUnicode()) inputString else Rabbit.zg2uni(inputString)
    }

    /**
     * method for getting string array
     * @param unicodeStringArray Unicode String Array
     * @return appropriate String Array according to device's encoding
     */
    fun getStringArray(unicodeStringArray: Array<String>): Array<String> {
        if (isUnicode())
            return unicodeStringArray
        val zawgyiStringArray = unicodeStringArray.clone()
        for (i in zawgyiStringArray.indices) {
            zawgyiStringArray[i] = Rabbit.uni2zg(zawgyiStringArray[i])
        }
        return zawgyiStringArray
    }
}
