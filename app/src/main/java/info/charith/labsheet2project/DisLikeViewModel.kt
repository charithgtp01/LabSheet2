package info.charith.labsheet2project

import android.app.Application
import android.preference.PreferenceManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DisLikeViewModel(application: Application) : AndroidViewModel(application) {
//    var disLikeCount: Int = 0

    private val _disLikeCount = MutableLiveData(loadDataFromPreferences())
    val disLikeCount: LiveData<Int> get() = _disLikeCount
    fun disLikeBtnClick() {
        _disLikeCount.value = _disLikeCount.value!! + 1
        saveDataToPreferences()
    }

    private fun saveDataToPreferences() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplication())
        val editor = sharedPreferences.edit()
        editor.putInt("disLikeCount", _disLikeCount.value!!)
        editor.apply()
    }

    private fun loadDataFromPreferences(): Int {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplication())
        return sharedPreferences.getInt("disLikeCount", 0)
    }
}