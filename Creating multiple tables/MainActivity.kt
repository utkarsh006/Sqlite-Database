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
            //Toast.makeText(this,folder.absolutePath.toString(), Toast.LENGTH_LONG).show()
        }

        myFile = File(folder,"Test.db")
        db = SQLiteDatabase.openOrCreateDatabase(myFile!!.absolutePath,null,null)

        createTable()

        var cursor = db!!.rawQuery("SELECT name FROM sqlite_master WHERE type='table' ", null)

          if(cursor.getCount()>0) {
              Toast.makeText(this,"Total Tables created = "+ cursor.getCount().toString(), Toast.LENGTH_LONG).show()
          }
    }


    // creating multiple tables inside the database
    fun createTable(){

        // if not exists mean that table is not present then a new table is created and vice versa

        var createTable : String
        createTable = "CREATE TABLE IF NOT EXISTS item(itemId INTEGER PRIMARY KEY AUTOINCREMENT, classId INTEGER" +
                "itemName TEXT, rate REAL, itemUnit TEXT, itemImg BLOB)"

        db!!.execSQL(createTable)

    }
}