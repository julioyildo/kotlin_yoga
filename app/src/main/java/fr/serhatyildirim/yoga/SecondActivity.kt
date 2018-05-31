package fr.serhatyildirim.yoga

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }



    fun randomMe(view: View){
        // Create an Intent to start the second activity
        val randomIntent = Intent(this, ThirdActivity::class.java)

        // Start the new activity.
        startActivity(randomIntent)
    }


}
