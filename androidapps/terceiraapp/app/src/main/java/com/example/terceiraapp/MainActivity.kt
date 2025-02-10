package com.example.terceiraapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.terceiraapp.databaseclasses.UsuarioManager
import com.example.terceiraapp.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var usuarioManager: UsuarioManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val sharedPreferences = this.getSharedPreferences("user",Context.MODE_PRIVATE)
        val user = sharedPreferences.getString("user","").toString()
        val pass = sharedPreferences.getString("pass","").toString()



        binding.textUsername.setText(user)
        binding.textPassword.setText(pass)


        binding.bttCriarUser.setOnClickListener {
            val intent = Intent(this,RegistarUtilizador::class.java)
            startActivity(intent)
        }


        binding.bttEntrar.setOnClickListener{
            if (binding.textUsername.text.toString().isEmpty() || binding.textPassword.text.toString().isEmpty()){

                Toast.makeText(this, user, Toast.LENGTH_SHORT).show()
                Toast.makeText(this, pass, Toast.LENGTH_SHORT).show()

                Toast.makeText(this, "Preencha todos os campos!!", Toast.LENGTH_SHORT).show()
            }else {

                if (binding.textUsername.text.toString().isNotEmpty() && binding.textPassword.text.toString().isNotEmpty()){
                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    editor.putString("user",binding.textUsername.text.toString())
                    editor.putString("pass",binding.textPassword.text.toString())
                    editor.apply()

                    usuarioManager = UsuarioManager(this)



                    lifecycleScope.launch {
                        val loginSucesso = usuarioManager.fazerLogin(binding.textUsername.text.toString(), binding.textPassword.text.toString())
                        if (loginSucesso) {
                            Toast.makeText(this@MainActivity, "Login realizado!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@MainActivity,Menu::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this@MainActivity, "User ou pass erradas!", Toast.LENGTH_SHORT).show()
                        }
                    }


                }else {
                    val intent = Intent(this,page1::class.java)
                    startActivity(intent)
                }

            }
        }
    }
}