package com.gzeinnumer.externalappenttextfilekt.helper

import android.os.Environment
import android.util.Log
import java.io.File


object FunctionGlobalDir {

    var getStorageCard = Environment.getExternalStorageDirectory().toString()
    var appFolder = "/ExternalAppentTextFileKt"

    private const val TAG = "FunctionGLobalDir_"

    fun myLogD(tag: String, msg: String) {
        Log.d("MyZein", tag + "_" + msg)
    }

    fun initFolder(): Boolean {
        // create folder
        val folder = File(getStorageCard + appFolder)
        if (!folder.exists()) {
            if (!creatingFolder(folder)) {
                return false
            }
        }
        return true
    }

    private fun creatingFolder(folder: File): Boolean {
        try {
            if (folder.mkdirs()) {
                myLogD(TAG, "Folder created")
            }
        } catch (e: Exception) {
            myLogD(TAG, "Folder not created")
            return false
        }
        return true
    }

    fun isFileExists(path: String): Boolean {
        val file = File(getStorageCard + path)
        return file.exists()
    }
}
