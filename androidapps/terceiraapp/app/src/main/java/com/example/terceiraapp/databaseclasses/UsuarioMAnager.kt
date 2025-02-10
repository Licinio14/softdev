package com.example.terceiraapp.databaseclasses

import android.content.Context

class UsuarioManager(context: Context) {
    private val database = AppDatabase.getDatabase(context)
    private val usuarioDao = database.usuarioDao()

    suspend fun cadastrarUsuario(username: String, password: String): Boolean {
        // Verifica se já existe um usuário com este username
        val usuarioExistente = usuarioDao.buscarPorUsername(username)
        if (usuarioExistente != null) {
            return false
        }

        // Cria novo usuário
        val novoUsuario = Usuario(
            username = username,
            password = password  // Em produção, você deve encriptar a senha
        )

        // Salva no banco
        usuarioDao.inserirUsuario(novoUsuario)
        return true
    }

    suspend fun fazerLogin(username: String, password: String): Boolean {
        val usuario = usuarioDao.verificarLogin(username, password)
        return usuario != null
    }

    suspend fun listarUsuarios(): List<Usuario> {
        return usuarioDao.getTodosUsuarios()
    }

}