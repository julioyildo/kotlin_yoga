package fr.serhatyildirim.yoga

import android.content.Intent
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import fr.serhatyildirim.yoga.R.drawable.button_home
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button_home.setOnClickListener {
                var intent = Intent(this , SecondActivity::class.java)
                startActivity(intent)
    }

        var mercuryFont = Typeface.createFromAsset(assets, "fonts/mercury_bold.ttf")
        var GeomanistLightFont = Typeface.createFromAsset(assets, "fonts/Geomanist-Light.otf")

        home_title.typeface = mercuryFont
        home_description.typeface = GeomanistLightFont
        button_home.typeface = mercuryFont


    }


    fun toastMe() {
        // val myToast = Toast.makeText(this, message, duration);
        val myToast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT)
        myToast.show()
    }





}
