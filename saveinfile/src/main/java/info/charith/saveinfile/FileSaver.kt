package info.charith.saveinfile

import android.content.Context
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

class FileSaver(private val context: Context) {

    fun writeToFile(fileName: String, data: String) {
        val fileOutputStream: FileOutputStream =
            context.openFileOutput(fileName, Context.MODE_PRIVATE)
        fileOutputStream.write(data.toByteArray())
    }

    fun readFromFile(fileName: String): String {
        val fileInputStream: FileInputStream = context.openFileInput(fileName)
        var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
        val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder: StringBuilder = StringBuilder()
        var text: String? = null

        while ({ text = bufferedReader.readLine();text }() != null)
            stringBuilder.append(text)

        return stringBuilder.toString()
    }


}