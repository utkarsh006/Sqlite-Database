- SQLite is a private/local database for android. It uses your phone's internal memory.
- DML - Insert, Update and delete
- DRL - Select statement

## Demonstration 🤪

1. Listview, SimpleCursorAdapter, SearchView, ContextMenu
2. Insert, Update, delete, select
3. First, Next, Prev, Last, Search, ViewAll

## SQLiteDatabase

- **SQLiteDatabase** is a class and instance of this class is used to perform insert, update and delete.

   ``` 
  If var db : SQLiteDatabase
       then we can call
       - db.insert, db.update, db.delete, db.execSQL("Write and execute your SQL Query over here")
       - db.rawQuery("SELECT * FROM TABLE WHERE COL1=? AND COL2=?", arrayOf("Agra","UttarPradesh")) 
       Hence, col1=agra and col2=uttarpradesh
       
   ```


## Cursor 

Cursor gives us the current set of records

var records = db.rawQuery("SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>1000", null)

```
while(records.moveToNext()) //this function moves us to the next records
{
  records.getString(0)  //fetches the first record
  records.getString(1)
  records.getString(2)
}

```

## SQLiteOpenHelper

- onCreate() - invoked when the class is loaded
- onUpgrade() - invoked only when we change our version
