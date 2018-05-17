package com.teamtreehouse.interactivestory.ui

import android.content.Intent
import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.teamtreehouse.interactivestory.R

class MainActivity:AppCompatActivity() {

    private var nameField: EditText? = null
    private var startButton: Button? = null

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameField = findViewById(R.id.nameEditText)
        startButton = findViewById(R.id.startButton)

        startButton!!.setOnClickListener {
            val name: String = nameField!!.getText().toString()
            startStory(name)
        }
    }

    override fun onResume() {
        super.onResume()
        nameField!!.setText("")
    }

    private fun startStory(name: String) {
        val intent = Intent(this, StoryActivity::class.java)
        val resources: Resources = getResources()
        val key: String = resources.getString(R.string.key_name)
        intent.putExtra(key, name)
        startActivity(intent)
    }
}