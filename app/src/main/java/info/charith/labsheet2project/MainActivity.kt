package info.charith.labsheet2project

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import info.charith.labsheet2project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding
    val likeViewModel: LikeViewModel by viewModels()
    val disLikeViewModel: DisLikeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        dataBinding.likeVM = likeViewModel
        dataBinding.lifecycleOwner = this
        dataBinding.btnLike.setOnClickListener {
            likeViewModel.likeBtnClick(this)
//            dataBinding.tvLikeCounter.text = likeViewModel.likeCount.toString()
            SharedPref(this).saveDataToPreferences(likeViewModel.likeCount.value ?: 0)
        }

        /*Data Binding*/
        dataBinding.disLikeVM = disLikeViewModel
        dataBinding.lifecycleOwner = this
        dataBinding.btnDisLike.setOnClickListener {
            disLikeViewModel.disLikeBtnClick()
//            dataBinding.tvDisLikeCounter.text = disLikeViewModel.disLikeCount.toString()
        }

        /*Observer*/
//        val likeObserver = Observer<Int> { newValue ->
//            dataBinding.tvLikeCounter.text = newValue.toString()
//        }
//
//        likeViewModel.likeCount.observe(this, likeObserver)
//
//        val disLikeObserver = Observer<Int> { newValue ->
//            dataBinding.tvDisLikeCounter.text = newValue.toString()
//        }
//
//        disLikeViewModel.disLikeCount.observe(this, disLikeObserver)
    }

    override fun onResume() {
        super.onResume()
        val likeCount=SharedPref(this).loadDataFromPreferences()
        likeViewModel.startFromSavedCount(likeCount)
//                    dataBinding.tvLikeCounter.text = likeViewModel.likeCount.toString()

    }
}