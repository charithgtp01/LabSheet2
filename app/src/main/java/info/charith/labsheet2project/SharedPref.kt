package info.charith.labsheet2project;

import android.content.Context
import android.content.SharedPreferences

class SharedPref(context: Context) {

    private val pref: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = pref.edit()

    fun saveDataToPreferences(value: Int) = editor.putInt("likeCount", value).apply()
    fun loadDataFromPreferences(): Int = pref.getInt("likeCount", 0)


}
