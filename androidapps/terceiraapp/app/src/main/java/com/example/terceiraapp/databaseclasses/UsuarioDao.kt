package com.example.terceiraapp.databaseclasses

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

// UsuarioDao.kt
@Dao
interface UsuarioDao {
    @Query("SELECT * FROM usuarios")
    fun getTodosUsuarios(): List<Usuario>

    @Insert
    suspend fun inserirUsuario(usuario: Usuario)

    @Query("SELECT * FROM usuarios WHERE username = :username")
    suspend fun buscarPorUsername(username: String): Usuario?

    @Query("SELECT * FROM usuarios WHERE username = :username AND password = :password")
    suspend fun verificarLogin(username: String, password: String): Usuario?
}