package fr.serhatyildirim.yoga

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.util.*
// Android extensions import statements for the two views to update
import kotlinx.android.synthetic.main.activity_third.title_music

class ThirdActivity : AppCompatActivity() {


    companion object {
        val EXTRA_VALUE = "EXTRA_VALUE"

        fun createIntent(context: Context, value: Int): Intent {
            return Intent(context, ThirdActivity::class.java).putExtra(EXTRA_VALUE, value)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        showRandomNumber()
    }





//Other class code...

    fun showRandomNumber() {
        // Get the count from the intent extras
        val count = intent.getIntExtra(EXTRA_VALUE, 0)

        // Generate the random number
       /* val random = Random()
        var randomInt = 0
        // Add one because the bound is exclusive
        if (count > 0) {
            // Add one because the bound is exclusive
            randomInt = random.nextInt(count + 1)
        }
*/
        // Display the random number.
        title_music.text = count.toString()

        // Substitute the max value into the string resource
        // for the heading, and update the heading
        /*textview_label.text = getString(R.string.random_heading, count)*/
    }
}
