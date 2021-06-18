package com.salem.biblequiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class LauncherActivity : AppCompatActivity() , View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        val imgbtn = findViewById<ImageButton>(R.id.ImgBtPlay)
        imgbtn.setOnClickListener(this);
    }

    override fun onClick(v: View?) {

    }
}