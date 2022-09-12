package com.viona.customui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.viona.customui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setMyButtonEnable()
        setActionButton()

    }

    private fun setMyButtonEnable() {
        val result = binding.myEditText.text
        binding.btnSubmit.isEnabled = result != null && result.toString().isNotEmpty()
    }

    private fun setActionButton() {
        binding.myEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(p0: Editable?) {
                //
            }

        })

        binding.btnSubmit.setOnClickListener {
            Toast.makeText(this, binding.myEditText.text, Toast.LENGTH_SHORT).show()
        }
    }
}