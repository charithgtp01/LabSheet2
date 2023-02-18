package info.charith.labsheet2project

import android.app.Application
import android.preference.PreferenceManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class LikeViewModel(application: Application) : AndroidViewModel(application) {
    //    var likeCount: Int = 0
    private val _likeCount = MutableLiveData<Int>(loadDataFromPreferences())
    val likeCount: LiveData<Int> get() = _likeCount

    fun likeBtnClick() {
//        likeCount++
        _likeCount.value = _likeCount.value!! + 1
        saveDataToPreferences()
    }

    fun saveDataToPreferences() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplication())
        val editor = sharedPreferences.edit()
        editor.putInt("likeCount", _likeCount.value!!)
        editor.apply()
    }

    fun loadDataFromPreferences(): Int {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplication())
        val serializedData = sharedPreferences.getInt("likeCount", 0)
        return serializedData
    }
}