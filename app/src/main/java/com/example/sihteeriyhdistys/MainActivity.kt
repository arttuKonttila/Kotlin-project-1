package com.example.sihteeriyhdistys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.text.TextWatcher as TextWatcher1

class MainActivity : AppCompatActivity() {
    private lateinit var editTextName: EditText
    private lateinit var searchButton: Button
    private lateinit var watcher: TextWatcher1
    private val controller = ApiController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val userData = controller.fetchUsersJson()

        try {
            setValues()
            editTextName.addTextChangedListener(watcher)
        } catch (e: Throwable) {
            val showErrorMessage = e
            Log.e(e.message.toString(), "Error #: ")
        }

        val btnOpenActivity: Button = findViewById(R.id.button_search)

        btnOpenActivity.setOnClickListener {
            val intent = Intent(this, Result::class.java)
            intent.putExtra("usersName", editTextName.text.toString())

            try{
                startActivity(intent)
            } catch(e: Throwable) {
                Log.e(e.message.toString(), "Error #: ")
                Toast.makeText(this, "Virhe Tapahtui", Toast.LENGTH_SHORT).show()
            }


            /*for(index:Int in userData.indices) {
                val tempName = userData[index].firstName + " " + userData[index].lastName

                if(editTextName.text.toString() == tempName || editTextName.text.toString().toLowerCase() == tempName.toLowerCase()) {

                }
                else {
                    Toast.makeText(this, "Ei Hakutuloksia", Toast.LENGTH_SHORT).show()
                }

            }*/
        }
    }

    private fun setValues() {
        watcher = object : TextWatcher1 {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val nameInput = editTextName.text.toString().trim()
                if (nameInput.isNotEmpty()) {
                    button_search.isEnabled = true
                }
                if (nameInput.isEmpty()) {
                    button_search.isEnabled = false
                }
            }
        }
        editTextName = findViewById(R.id.edit_text_name)
        searchButton = findViewById(R.id.button_search)
    }

}
