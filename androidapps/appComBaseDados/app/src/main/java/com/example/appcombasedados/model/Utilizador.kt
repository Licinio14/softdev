package com.example.appcombasedados.model

class Utilizador(val id: Int = 0, val username: String = "", val password: String = "") {
    override fun toString(): String {
        return "Utilizador(id=$id,username='$username',password='$password')"
    }
}