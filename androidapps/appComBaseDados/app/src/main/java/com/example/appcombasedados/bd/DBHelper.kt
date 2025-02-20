package com.example.appcombasedados.bd

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.appcombasedados.model.Utilizador

class DBHelper (context: Context) : SQLiteOpenHelper(context, "database.db",null,1) {

    val sql = arrayOf(
        "Create Table utilizador (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)",
        "INSERT INTO utilizador (username, password) VALUES ('user','pass');",
        "Insert into utilizador (username,password) Values ('admin','pwd');",
    )

    override fun onCreate(db: SQLiteDatabase?) {
        sql.forEach {
            db?.execSQL(it)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("Drop Table utilizador")
        onCreate(db)
    }

    fun utilizadorInsert(username: String, password: String): Long{

        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("username",username)
        contentValues.put("password",password)
        val res = db.insert("utilizador",null,contentValues)
        db.close()
        return res
    }

    fun utilizadorUpdate(id: Int, username: String, password: String): Int{
        val dp = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("username", username)
        contentValues.put("password",password)
        val res = dp.update("utilizador",contentValues,"username = ?", arrayOf(username))
        dp.close()
        return res
    }

    fun utilizadorDelete(id: Int): Int {
        val dp = this.writableDatabase
        val res = dp.delete("utilizador","id = ?", arrayOf(id.toString()))
        dp.close()
        return res
    }

    fun utilizadorSelect(): Cursor {
        val dp = this.readableDatabase
        val c = dp.rawQuery("Select * from utilizador",null)
        dp.close()
        return c
    }

    fun utilizadorVerificar(username: String, password: String): Any {

        val dp = this.readableDatabase
        val c = dp.rawQuery("Select id from utilizador where username = '$username' and password = '$password' ",null)
        var resposta: Int

        if (c.count == 1){
            c.moveToFirst()
            val idIndex = c.getColumnIndex("id")
            return c.getInt(idIndex)
        }else {
            resposta = -1
        }
        dp.close()

        return resposta

    }

    fun utilizadorListSelectAll(): ArrayList<Utilizador> {
        val dp = this.readableDatabase
        val c = dp.rawQuery("Select * from utilizador",null)
        val listaUtilizador: ArrayList<Utilizador> = ArrayList()
        if (c.count > 0){
            c.moveToFirst()
            do {
                val idIndex = c.getColumnIndex("id")
                val usernameIndex = c.getColumnIndex("username")
                val passwordIndex = c.getColumnIndex("password")
                val id = c.getInt(idIndex)
                val username = c.getString(usernameIndex)
                val password = c.getString(passwordIndex)
                listaUtilizador.add(Utilizador(id,username,password))
            }while (c.moveToNext())
        }

        dp.close()
        return listaUtilizador
    }

    fun utilizadorSelectById(id: Int): Cursor{
        val db = this.readableDatabase
        return db.rawQuery("Select * from utilizador where id = $id",null)
    }

    fun utilizadorObjectSelectById(id: Int): Utilizador {
        val dp = this.readableDatabase
        val c = dp.rawQuery("Select * from utilizador where id = ?", arrayOf((id.toString())))
        var utilizador = Utilizador()
        if (c.count == 1 ){
            c.moveToFirst()
            val idIndex = c.getColumnIndex("id")
            val usernameIndex = c.getColumnIndex("username")
            val passwordIndex = c.getColumnIndex("password")
            val id = c.getInt(idIndex)
            val username = c.getString(usernameIndex)
            val password = c.getString(passwordIndex)
            utilizador = Utilizador(id,username,password)
        }

        dp.close()
        return utilizador
    }

}