package com.example.mvvmloginscreendemo.util

import android.content.Context
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("setError")
fun TextInputLayout.setCustomError(error: String?) {
    this.error = error
}


