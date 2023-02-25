package info.charith.saveinfile

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import info.charith.saveinfile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var dataBinding: ActivityMainBinding
    private val viewModel: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = this
        dataBinding.btnSave.setOnClickListener {
            FileSaver(this).writeToFile("test.txt", dataBinding.etData.text.toString());
        }

        dataBinding.btnView.setOnClickListener {
            val value = FileSaver(this).readFromFile("test.txt")
            viewModel.viewButtonClicked(value)
        }
    }

}