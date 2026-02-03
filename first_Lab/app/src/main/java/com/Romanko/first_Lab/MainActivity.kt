package com.Romanko.first_Lab

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPhone = findViewById<Button>(R.id.button2)
        val btnEmail = findViewById<Button>(R.id.button3)
        val input = findViewById<EditText>(R.id.user_email)
        val inputPassword = findViewById<EditText>(R.id.user_password)
        val inputPassword2 = findViewById<EditText>(R.id.user_password2)
        val btnRegister = findViewById<Button>(R.id.button)
        selectButton(btnEmail, btnPhone)
        var isEmailSelected = false
        btnEmail.setOnClickListener {
            input.text.clear()
            input.hint = "Введите email"
            input.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            selectButton(btnEmail, btnPhone)
            isEmailSelected = true
        }

        btnPhone.setOnClickListener {
            input.text.clear()
            input.hint = "Введите номер телефона"
            input.inputType = InputType.TYPE_CLASS_PHONE
            selectButton(btnPhone, btnEmail)
            isEmailSelected = false
        }

        btnRegister.setOnClickListener {
            val text = input.text.toString().trim()
            val password = inputPassword.text.toString()
            val password2 = inputPassword2.text.toString()

            if (isEmailSelected && !text.contains("@")) {
                Toast.makeText(this, "где вы видели email без @???", Toast.LENGTH_SHORT).show()
            } else if (!isEmailSelected && !text.contains("+")) {
                Toast.makeText(this, "У нас перед номером телефона ставим +", Toast.LENGTH_SHORT).show()
            } else if (password.length < 8) {
                Toast.makeText(this, "Пароль слаб. Он должен состоять из минимум 8 символов", Toast.LENGTH_SHORT).show()
            } else if (password != password2) {
                Toast.makeText(this, "Пароли не совпали", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Регистрация успешна! :D", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun selectButton(selected: Button, other: Button) {
        selected.setBackgroundColor(Color.parseColor("#6200ee"))
        other.setBackgroundColor(Color.LTGRAY)
    }
}



