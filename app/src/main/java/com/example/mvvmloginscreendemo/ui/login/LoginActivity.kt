package com.example.mvvmloginscreendemo.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmloginscreendemo.R
import com.example.mvvmloginscreendemo.databinding.ActivityLoginBinding
import com.example.mvvmloginscreendemo.util.makeToast

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.loginViewModel = loginViewModel
        binding.lifecycleOwner = this
        loginViewModel.getLoginResult().observe(this, Observer {
            Log.d("Test", "Login Result : $it")
            this.makeToast("Welcome $it")
        })
    }
}