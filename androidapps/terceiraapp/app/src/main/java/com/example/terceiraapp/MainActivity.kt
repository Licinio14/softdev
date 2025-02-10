package com.example.terceiraapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val sharedPreferences = this.getSharedPreferences("user",Context.MODE_PRIVATE)
        val user = sharedPreferences.getString("user","").toString()
        val pass = sharedPreferences.getString("pass","").toString()



        binding.textUsername.setText(user)
        binding.textPassword.setText(pass)




        binding.bttEntrar.setOnClickListener{
            if (binding.textUsername.text.toString().isEmpty() || binding.textPassword.text.toString().isEmpty()){

                Toast.makeText(this, user, Toast.LENGTH_SHORT).show()
                Toast.makeText(this, pass, Toast.LENGTH_SHORT).show()

                Toast.makeText(this, "Preencha todos os campos!!", Toast.LENGTH_SHORT).show()
            }else {

                if (binding.textUsername.text.toString() == "user" && binding.textPassword.text.toString() == "pass"){
                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    editor.putString("user",binding.textUsername.text.toString())
                    editor.putString("pass",binding.textPassword.text.toString())
                    editor.apply()


                    val intent = Intent(this,Menu::class.java)
                    startActivity(intent)
                }else {
                    val intent = Intent(this,page1::class.java)
                    startActivity(intent)
                }

            }
        }
    }
}