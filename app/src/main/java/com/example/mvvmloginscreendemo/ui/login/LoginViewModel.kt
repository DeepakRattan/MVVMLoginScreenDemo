package com.example.mvvmloginscreendemo.ui.login

import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var emailLiveData = MutableLiveData<String>()
    var passwordLiveData = MutableLiveData<String>()
    var confirmPasswordLiveData = MutableLiveData<String>()

    // LiveData for errors
    var emailError = MutableLiveData<String>()
    var passwordError = MutableLiveData<String>()
    var confirmPasswordError = MutableLiveData<String>()

    private var loginResult = MutableLiveData<String>()

    fun getLoginResult(): LiveData<String> = loginResult

    fun performValidation() {
        emailError.value = null
        passwordError.value = null
        confirmPasswordError.value = null

        if (TextUtils.isEmpty(emailLiveData.value)) {
            emailError.value = "Empty field. Please enter a valid email-Id"
            return
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailLiveData.value).matches()) {
            emailError.value = "Invalid. Please enter a valid email-Id"
            return
        }
        if (TextUtils.isEmpty(passwordLiveData.value)) {
            passwordError.value = "Empty field. Please enter valid password"
            return
        }
        if (passwordLiveData.value?.length ?: 0 < 6) {
            passwordError.value = "Weak password. Please enter a strong one"
            return
        }
        if (TextUtils.isEmpty(confirmPasswordLiveData.value)) {
            confirmPasswordError.value = "Empty field."
            return
        }
        if (confirmPasswordLiveData.value!!.length < 6) {
            confirmPasswordError.value = "Weak password. Please enter a strong one"
            return
        }
        if (passwordLiveData.value != confirmPasswordLiveData.value) {
            confirmPasswordError.value = "Passwords don't match"
            return
        }
        loginResult.value = "Valid Credentials"
    }

}