package com.example.scorekeeper

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ToggleButton

class settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        LoadSettings()

        val toggleButton : ToggleButton = findViewById(R.id.toggleButtonSetting);

        toggleButton.setOnCheckedChangeListener{ _,isChecked ->

                val sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.apply{
                    putBoolean("isChecked",isChecked)
                }.commit()
        }

    }

    private fun LoadSettings(){
        val toggleButton : ToggleButton = findViewById(R.id.toggleButtonSetting);
        val sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val isChecked = sharedPreferences.getBoolean("isChecked",false);
      toggleButton.isChecked = isChecked
    }
}