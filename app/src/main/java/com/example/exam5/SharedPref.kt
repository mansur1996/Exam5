package com.example.exam5

import android.content.Context
import androidx.core.content.edit

class SharedPref(context: Context) {
    private val pref = context.getSharedPreferences("Caches", Context.MODE_PRIVATE)

    var isSaved: Boolean
        get() = pref.getBoolean("isSaved", false)
        set(value) = pref.edit {
            this.putBoolean("isSaved", value)
        }
}