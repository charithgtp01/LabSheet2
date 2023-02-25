package info.charith.labsheet2project

import android.app.Activity
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LikeViewModel : ViewModel() {
    //    var likeCount: Int = 0
    private val _likeCount =
        MutableLiveData(0)
    val likeCount: LiveData<Int> get() = _likeCount

    fun likeBtnClick(activity: Activity) {
//        likeCount++
        _likeCount.value = _likeCount.value!! + 1
    }


    //This will skip setting default value to 0
    fun startFromSavedCount(likes:Int){
        _likeCount.value=likes
    }
}