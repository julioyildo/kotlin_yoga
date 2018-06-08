package fr.serhatyildirim.yoga

import android.content.Intent
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import fr.serhatyildirim.yoga.R.id.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    val SLEEP = 0
    val STRESS = 1
    val CALM = 2
    val FOCUSED = 3
    val ANXIETY = 4
    val CHECKING= 5


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        var mercuryFont = Typeface.createFromAsset(assets, "fonts/mercury_bold.ttf")
        var GeomanistLightFont = Typeface.createFromAsset(assets, "fonts/Geomanist-Light.otf")
        second_title.typeface = mercuryFont
        second_description.typeface = GeomanistLightFont



        btn_sleep.setOnClickListener {
            clickMenu(SLEEP)
        }

        btn_stressed.setOnClickListener {
            clickMenu(STRESS)
        }

        btn_calm.setOnClickListener {
            clickMenu(CALM)
        }

        btn_focused.setOnClickListener {
            clickMenu(FOCUSED)
        }

        btn_anxiety.setOnClickListener {
            clickMenu(ANXIETY)
        }

        btn_checking.setOnClickListener {
            clickMenu(CHECKING)
        }


    }


    private fun clickMenu(index: Int) {
        when(index) {
            SLEEP -> {
                val value = SLEEP // valeur arbitraire
                startActivity(ThirdActivity.createIntent(this, value))
            }
            STRESS -> {
                val value = STRESS // valeur arbitraire
                startActivity(ThirdActivity.createIntent(this, value))
            }
            CALM -> {
                val value = CALM // valeur arbitraire
                startActivity(ThirdActivity.createIntent(this, value))
            }
            FOCUSED -> {
                val value = FOCUSED // valeur arbitraire
                startActivity(ThirdActivity.createIntent(this, value))
            }
            ANXIETY -> {
                val value = ANXIETY // valeur arbitraire
                startActivity(ThirdActivity.createIntent(this, value))
            }
            CHECKING -> {
                val value = CHECKING // valeur arbitraire
                startActivity(ThirdActivity.createIntent(this, value))
            }
        }
    }
}
