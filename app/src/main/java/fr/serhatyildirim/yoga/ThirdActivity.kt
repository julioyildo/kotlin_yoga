package fr.serhatyildirim.yoga


import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

// Android extensions import statements for the two views to update

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        //showRandomNumber()
        mediaPlayer = MediaPlayer.create(this, R.raw.meditation_music)
        leftTime = findViewById(R.id.currentTime)
        rightTime = findViewById(R.id.duration)
        prevButton = findViewById<Button>(R.id.prevButton)
        playButton = findViewById<Button>(R.id.play_btn)
        nextButton = findViewById<Button>(R.id.nextButton)
        seekBar = findViewById<SeekBar>(R.id.seekBar)


    }

    private var mediaPlayer: MediaPlayer? =null
    private var leftTime:TextView? = null
    private var rightTime: TextView? = null
    private var seekBar: SeekBar? = null
    private var prevButton:Button? = null
    private var playButton:Button? = null
    private var nextButton:Button? = null



    //init {

       // this.mediaPlayer = MediaPlayer.create(this, R.raw.meditation_music)
       // this.leftTime   = findViewById(R.id.currentTime)
        //this.rightTime  = findViewById(R.id.duration)
        //this.playButton = findViewById(R.id.play_btn)

        //this.nextButton = findViewById(R.id.nextButton)
        //this.seekBar    = findViewById(R.id.seekBar)



   // }


    companion object {
        val EXTRA_VALUE = "EXTRA_VALUE"

        fun createIntent(context: Context, value: Int): Intent {
            return Intent(context, ThirdActivity::class.java).putExtra(EXTRA_VALUE, value)
        }
    }




   /* private fun clickMenu(view: TextView) {

        when(view) {
            prevButton->{

            }
            playButton -> {

            }

            nextButton -> {

            }



        }
    }
*/
    //public void pauseMusic() {

    //}

    //public void startMusic() {

    //}

//Other class code...

    fun showRandomNumber() {
        // Get the count from the intent extras
       // val count = intent.getIntExtra(EXTRA_VALUE, 0)

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
       // title_music.text = count.toString()

        // Substitute the max value into the string resource
        // for the heading, and update the heading
        /*textview_label.text = getString(R.string.random_heading, count)*/
    }


}
