package me.myatminsoe.mdetect

import android.content.Context
import android.widget.Toast

object MMToast {

    private var toast: Toast? = null

    fun showShortToast(context: Context, message: CharSequence) {
        toast?.cancel()
        toast = Toast.makeText(context, MDetect.getText(message.toString()), Toast.LENGTH_SHORT)
        toast!!.show()
    }

    fun showLongToast(context: Context, message: CharSequence) {
        toast?.cancel()
        toast = Toast.makeText(context, MDetect.getText(message.toString()), Toast.LENGTH_LONG)
        toast!!.show()
    }
}
