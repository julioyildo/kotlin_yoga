package fr.serhatyildirim.yoga

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import fr.serhatyildirim.yoga.R.id.btn_sleep_description
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    val MENU_SLEEP = 0
    val MENU_STRESS = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        btn_sleep.setOnClickListener {
            clickMenu(MENU_SLEEP)
        }
        btn_stressed.setOnClickListener {
            clickMenu(MENU_STRESS)
        }

    }


    private fun clickMenu(index: Int) {

        when(index) {
            MENU_SLEEP -> {
                val value = MENU_SLEEP // valeur arbitraire
                startActivity(ThirdActivity.createIntent(this, value))
            }

            MENU_STRESS -> {
                val value = MENU_STRESS // valeur arbitraire
                startActivity(ThirdActivity.createIntent(this, value))
            }
        }
    }




}
