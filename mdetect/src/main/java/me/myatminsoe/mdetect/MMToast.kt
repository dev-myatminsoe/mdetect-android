package me.myatminsoe.mdetect

import android.content.Context
import android.widget.Toast

object MMToast {

    val LENGTH_SHORT = Toast.LENGTH_SHORT
    val LENGTH_LONG = Toast.LENGTH_LONG

    fun makeText(context: Context, message: CharSequence, duration: Int): Toast {
        var charSequence = message
        if (!MDetect.isUnicode()) charSequence = Rabbit.uni2zg(charSequence.toString())
        return Toast.makeText(context, charSequence, duration)
    }

    fun makeText(context: Context, resId: Int, duration: Int): Toast {
        var message = context.resources.getString(resId)
        if (!MDetect.isUnicode()) message = Rabbit.uni2zg(message)
        return Toast.makeText(context, message, duration)
    }
}
