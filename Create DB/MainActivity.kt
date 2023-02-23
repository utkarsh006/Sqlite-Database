package com.example.sqlite

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Toast
import java.io.File

class MainActivity : AppCompatActivity() {

    var destinationFile: File ?= null
    var myFile: File ?= null
    var db: SQLiteDatabase ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun createDb(view:View){

        //created a database folder
        val folder = File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).toString() + "Database")
        if(!folder.exists()){
            folder.mkdir()
        }

        else{
            Toast.makeText(this,folder.absolutePath.toString(), Toast.LENGTH_LONG).show()
        }

        myFile = File(folder,"Test.db")
        db = SQLiteDatabase.openOrCreateDatabase(myFile!!.absolutePath,null,null)
    }
}