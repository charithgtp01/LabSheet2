package info.charith.labsheet2project

import android.app.Application
import android.preference.PreferenceManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class LikeViewModel(application: Application) : AndroidViewModel(application) {
    //    var likeCount: Int = 0
    private val _likeCount = MutableLiveData(loadDataFromPreferences())
    val likeCount: LiveData<Int> get() = _likeCount

    fun likeBtnClick() {
//        likeCount++
        _likeCount.value = _likeCount.value!! + 1
        saveDataToPreferences()
    }

    private fun saveDataToPreferences() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplication())
        val editor = sharedPreferences.edit()
        editor.putInt("likeCount", _likeCount.value!!)
        editor.apply()
    }

    private fun loadDataFromPreferences(): Int {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplication())
        return sharedPreferences.getInt("likeCount", 0)
    }
}