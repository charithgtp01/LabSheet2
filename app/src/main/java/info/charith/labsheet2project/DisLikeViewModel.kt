package info.charith.labsheet2project

import android.app.Application
import android.preference.PreferenceManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DisLikeViewModel(application: Application) : AndroidViewModel(application) {
//    var disLikeCount: Int = 0

    private val _disLikeCount = MutableLiveData<Int>(loadDataFromPreferences())
    val disLikeCount: LiveData<Int> get() = _disLikeCount
    fun disLikeBtnClick() {
        _disLikeCount.value = _disLikeCount.value!! + 1
        saveDataToPreferences()
    }

    fun saveDataToPreferences() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplication())
        val editor = sharedPreferences.edit()
        editor.putInt("disLikeCount", _disLikeCount.value!!)
        editor.apply()
    }

    fun loadDataFromPreferences(): Int {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplication())
        val serializedData = sharedPreferences.getInt("disLikeCount", 0)
        return serializedData
    }
}