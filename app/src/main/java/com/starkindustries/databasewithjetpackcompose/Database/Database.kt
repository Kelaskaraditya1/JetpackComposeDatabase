package com.starkindustries.databasewithjetpackcompose.Database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.starkindustries.databasewithjetpackcompose.Keys.Keys
import com.starkindustries.databasewithjetpackcompose.Model.Student

class Database(context_: Context,databaseName:String,version:Int):SQLiteOpenHelper(context_,databaseName,null,version){
    lateinit var context: Context
    init {
        this.context=context_
    }
    override fun onCreate(sql: SQLiteDatabase?) {
            sql?.execSQL("Create table "+Keys.TABLE_NAME+" ( "+Keys.STUDENT_ID+" text, "+Keys.NAME+" text, "+Keys.USERNAME+" text, "+Keys.EMAIL+" text, "+Keys.DEPARTMENT+" text, "+Keys.PASSWORD+" text )")
    }

    override fun onUpgrade(sql: SQLiteDatabase?, p1: Int, p2: Int) {
        sql?.execSQL("drop table "+Keys.TABLE_NAME+" if exists")
        onCreate(sql)
    }
    fun insertData(student: Student):Int{
        var database = this.writableDatabase
        var contentValues = ContentValues()
        contentValues.put(Keys.STUDENT_ID,student.getStudentId())
        contentValues.put(Keys.NAME,student.getName())
        contentValues.put(Keys.USERNAME,student.getUsername())
        contentValues.put(Keys.EMAIL,student.getEmail())
        contentValues.put(Keys.DEPARTMENT,student.getDepartment())
        contentValues.put(Keys.PASSWORD,student.getPassword())
        database.insert(Keys.TABLE_NAME,null,contentValues)
        database.close()
        return 1
    }

    fun getCount():Int {

        var database = this.writableDatabase
        var cursor = database.rawQuery("select * from "+Keys.TABLE_NAME,null)
        return cursor.count
    }

    fun login(username:String,passwod:String):Boolean{
        var database = this.writableDatabase
        var cursor = database.query(Keys.TABLE_NAME, arrayOf(Keys.STUDENT_ID,Keys.NAME,Keys.USERNAME,Keys.EMAIL,Keys.USERNAME,Keys.PASSWORD),Keys.USERNAME+"=?"+" and "+Keys.PASSWORD+"=?",
            arrayOf<String>(username,passwod),null,null,null)
        if(cursor.count!=0)
            return true
        return false
    }

    fun getStudent(studentId:String):Student?{
        var database = this.writableDatabase
        var cursor = database.query(Keys.TABLE_NAME, arrayOf(Keys.STUDENT_ID,Keys.NAME,Keys.USERNAME,Keys.EMAIL,Keys.USERNAME,Keys.PASSWORD),Keys.STUDENT_ID+"=?",
            arrayOf<String>(studentId),null,null,null)
        var student:Student? = null
        if(cursor.count!=0&&cursor.moveToFirst())
            student = Student(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5))
        return student
    }

    fun getSutdentbyUsername(username:String?):Student{
        var database = this.writableDatabase
        var cursor = database.query(Keys.TABLE_NAME, arrayOf(Keys.STUDENT_ID,Keys.NAME,Keys.USERNAME,Keys.EMAIL,Keys.DEPARTMENT,Keys.PASSWORD),Keys.USERNAME+"=?",
            arrayOf(username),null,null,null
        )
        var student = Student()
        if(cursor.count!=0&&cursor.moveToFirst()){
            student.setStudentId(cursor.getString(0))
            student.setName(cursor.getString(1))
            student.setUsername(cursor.getString(2))
            student.setEmail(cursor.getString(3))
            student.setDepartment(cursor.getString(4))
        }
        return student
    }

    fun updateStudent(student: Student,studentId: String):Student?{
        var database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Keys.USERNAME,student.getUsername())
        contentValues.put(Keys.NAME,student.getName())
        contentValues.put(Keys.EMAIL,student.getEmail())
        contentValues.put(Keys.DEPARTMENT,student.getDepartment())
        contentValues.put(Keys.PASSWORD,student.getPassword())
        database.update(Keys.TABLE_NAME,contentValues,Keys.STUDENT_ID+"=?", arrayOf(studentId))
        return getStudent(studentId)
    }

    fun deleteStudent(studentId:String?){
        var database = this.writableDatabase
        database.delete(Keys.TABLE_NAME,Keys.STUDENT_ID+"=?", arrayOf(studentId))
        Toast.makeText(context, "Student with Id $studentId deleted Successfully    ", Toast.LENGTH_SHORT).show()
    }
}
