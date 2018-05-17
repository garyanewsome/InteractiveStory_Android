package com.teamtreehouse.interactivestory.ui

import android.content.Intent
import android.content.Intent.getIntent
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.teamtreehouse.interactivestory.R
import com.teamtreehouse.interactivestory.model.Page
import com.teamtreehouse.interactivestory.model.Story
import java.util.*

class StoryActivity: AppCompatActivity() {


    private val TAG = StoryActivity::class.java.simpleName

    private var pageStack = Stack<Int>()
    private var name: String? = null
    private var story: Story? = null
    private var storyImageView: ImageView? = null
    private var storyTextView: TextView? = null
    private var choice1Button: Button? = null
    private var choice2Button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        storyImageView = findViewById(R.id.storyImageView)
        storyTextView = findViewById(R.id.storyTextView)
        choice1Button = findViewById(R.id.choice1Button)
        choice2Button = findViewById(R.id.choice2Button)

        val intent: Intent = getIntent()
        name = intent.getStringExtra(getString(R.string.key_name))
        if (name == null || name!!.isEmpty()) name = "Friend"
        Log.d(TAG, name)

        story = Story()
        loadPage(0)

    }

    private fun loadPage(pageNumber: Int) {
        pageStack.push(pageNumber)

        val page: Page? = story?.getPage(pageNumber)

        val image: Drawable? = ContextCompat.getDrawable(this, page!!.imageId)
        storyImageView!!.setImageDrawable(image)

        var pageText: String = getString(page.textId)
        pageText = String.format(pageText, name)

        storyTextView!!.setText(pageText)

        if(page.isFinalPage) {
            choice1Button!!.setVisibility(View.INVISIBLE)
            choice2Button!!.setText(getString(R.string.play_again_button_text))
            choice2Button!!.setOnClickListener {
//                finish()
                loadPage(0)
            }

        } else {
            loadButtons(page)
        }
    }

    private fun loadButtons(page: Page) {
        choice1Button!!.setVisibility(View.VISIBLE)
        choice1Button!!.setText(page.choice1!!.textId)
        choice1Button!!.setOnClickListener {
            val nextPage = page.choice1!!.nextPage
            loadPage(nextPage)
        }
        choice2Button!!.setVisibility(View.VISIBLE)
        choice2Button!!.setText(page.choice2!!.textId)
        choice2Button!!.setOnClickListener {
            val nextPage = page.choice2!!.nextPage
            loadPage(nextPage)
        }
    }

    override fun onBackPressed() {
        pageStack.pop()
        Log.d(TAG, "pop")
        if(pageStack.isEmpty()) {
            Log.d(TAG, "if")
            super.onBackPressed()
        } else {
            Log.d(TAG, "else")
            loadPage(pageStack.pop())
        }
    }
}
