package fr.serhatyildirim.yoga


import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

// Android extensions import statements for the two views to update

 class ThirdActivity : AppCompatActivity() {


     private var mediaPlayer: MediaPlayer? = null
    private var leftTime:TextView? = null
    private var rightTime: TextView? = null
    private var seekBar: SeekBar? = null
    private var prevButton:Button? = null
    private var playButton:Button? = null
    private var nextButton:Button? = null


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

        playButton?.setOnClickListener{clickMenu(playButton!!)}
       // prevButton?.setOnClickListener(this)
       // nextButton?.setOnClickListener(this)


    }



    companion object {
        val EXTRA_VALUE = "EXTRA_VALUE"

        fun createIntent(context: Context, value: Int): Intent {
            return Intent(context, ThirdActivity::class.java).putExtra(EXTRA_VALUE, value)
        }
    }



     private fun  clickMenu(view: View) {

         when(view) {
            prevButton->{

            }
            playButton -> {
                if(mediaPlayer?.isPlaying!!) {
                    this.pauseMusic()

                } else {
                    this.startMusic()

                }
            }

            nextButton -> {

            }

        }
    }



   private fun pauseMusic(){
        if (mediaPlayer != null){
           mediaPlayer?.pause()
           playButton?.setBackgroundResource(android.R.drawable.ic_media_pause)
        }
    }



    private fun startMusic() {
        if (mediaPlayer != null){
            mediaPlayer?.start()
            playButton?.setBackgroundResource(android.R.drawable.ic_media_play)
        }
    }

//Other class code...

    //fun showRandomNumber() {
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
   // }


}
