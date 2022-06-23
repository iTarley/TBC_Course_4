package com.example.tbc_course_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tbc_course_4.databinding.ActivityMainBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.saveBtn.setOnClickListener {
            saveBtn()
        }
        binding.clearBtn.setOnLongClickListener {
            clearBtn()
            true
        }


    }

    private fun saveBtn(){

        val email = binding.emailEditText.text.toString()
        val firstName = binding.firstNameEditText.text.toString()
        val lastName = binding.lastNameEditText.text.toString()
        val username = binding.userNameEditText.text.toString()
        val age = binding.ageEditText.text.toString()
        val password = binding.passwordEditText.text.toString()

        if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.emailInputLayout.error = null

        }else{
            binding.emailInputLayout.error = "Please enter correct email address"
        }
        if (firstName.isEmpty()){
            binding.firstNameInputLayout.error = "Please enter your name"
        }else{
            binding.firstNameInputLayout.error = null
        }
        if (lastName.isEmpty()){
            binding.lastNameInputLayout.error = "Please enter your last name"
        }else{
            binding.lastNameInputLayout.error = null
        }
        if (username.length < 10){
            binding.userNameInputLayout.error = "Username must contain minimum 10 letters"
        }else{
            binding.userNameInputLayout.error = null
        }
        if (age.isEmpty() || age.startsWith("0")){
            binding.ageInputLayout.error = "Please enter correct age"
        }else{
            binding.ageInputLayout.error = null
        }
        if (password.isEmpty()){
            binding.passwordInputLayout.error = "Please enter your password"
        }else{
            binding.passwordInputLayout.error = null
        }
    }
    private fun clearBtn(){

        binding.emailEditText.setText("")
        binding.emailInputLayout.error = null
        binding.firstNameEditText.setText("")
        binding.firstNameInputLayout.error = null
        binding.lastNameEditText.setText("")
        binding.lastNameInputLayout.error = null
        binding.userNameEditText.setText("")
        binding.userNameInputLayout.error = null
        binding.ageEditText.setText("")
        binding.ageInputLayout.error = null
        binding.passwordEditText.setText("")
        binding.passwordInputLayout.error = null
        Toast.makeText(this, "Input reset", Toast.LENGTH_SHORT).show()
    }
}