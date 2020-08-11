package com.gzeinnumer.externalappenttextfilekt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gzeinnumer.externalappenttextfilekt.helper.FunctionGlobalDir
import com.gzeinnumer.externalappenttextfilekt.helper.FunctionGlobalFile
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity_"

    var msg = "externalappenttextfilekt\n"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = TAG

        if (FunctionGlobalDir.isFileExists(FunctionGlobalDir.appFolder + "/File.txt")) {
            if (FunctionGlobalFile.appentText(FunctionGlobalDir.appFolder + "/File.txt", "Pesan yang dikirim")) {
                msg += "Line baru ditambah ke file "
                tv.text = msg
            } else {
                msg += "Ada error ketika add pesan"
                tv.text = msg
            }
        } else {
            if (FunctionGlobalFile.initFile("Text yang dibuat di file")) {
                val list: List<String>? = FunctionGlobalFile.readFile(FunctionGlobalDir.appFolder + "/File.txt")
                if (list != null) {
                    msg += "Jumlah line di file ada " + list.size
                    tv.text = msg
                } else {
                    msg += "Gagal membaca data"
                    tv.text = msg
                }
            } else {
                msg += "File gagal dibuat "
                tv.text = msg
            }
        }
    }
}