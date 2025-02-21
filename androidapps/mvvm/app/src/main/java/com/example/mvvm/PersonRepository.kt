package com.example.mvvm

class PersonRepository {
    fun login(email: String, password:String): Boolean {
        return (email.equals("admin") && password.equals(("pass")))
    }
}