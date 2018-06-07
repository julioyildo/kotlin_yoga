package fr.serhatyildirim.yoga


import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import fr.serhatyildirim.yoga.R.id.seekBar
import java.lang.reflect.Array
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

// Android extensions import statements for the two views to update
data class Music(var name: String, var song: MediaPlayer, var position: Int)

 class ThirdActivity : AppCompatActivity() {

     private var titleMusic: TextView? = null
     private var currentSession: TextView? = null
     //private var  currentMusicInformations:  =null
     private var mediaPlayer: MediaPlayer? = null
     private var leftTime:TextView? = null
     private var rightTime: TextView? = null
     private var seekBar: SeekBar? = null
     private var prevButton:Button? = null
     private var playButton:Button? = null
     private var nextButton:Button? =null
     private var handler: Handler? = null


     private var musics: ArrayList<Music>? = null
     private var index: Int = 0





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)


        this.musics = arrayListOf(
                Music("Pour un beau réveille",  MediaPlayer.create(this, R.raw.matinal), 0),
                Music("Avant une bonne nuit",  MediaPlayer.create(this, R.raw.soiree), 1)
        )


        titleMusic = findViewById<TextView>(R.id.title_music)
        currentSession = findViewById<TextView>(R.id.track)
        mediaPlayer = this.musics!![this.index].song
        leftTime = findViewById<TextView>(R.id.currentTime)
        rightTime = findViewById<TextView>(R.id.duration)
        prevButton = findViewById<Button>(R.id.prevButton)
        playButton = findViewById<Button>(R.id.play_btn)
        nextButton = findViewById<Button>(R.id.nextButton)
        seekBar = findViewById<SeekBar>(R.id.seekBar)
        handler = Handler()
        playButton?.setOnClickListener{clickMenu(playButton!!)}
        prevButton?.setOnClickListener{clickMenu(prevButton!!)}
        nextButton?.setOnClickListener{clickMenu(nextButton!!)}



        seekBar?.max = mediaPlayer?.duration!!



        seekBar?.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                if (b){
                    mediaPlayer?.seekTo(i)
                }

                var dateFormat =  SimpleDateFormat("mm:ss")
                var currentPos = mediaPlayer?.currentPosition
                var  duration = mediaPlayer?.duration

                leftTime?.text = dateFormat.format(currentPos)
                rightTime?.text = dateFormat.format(duration)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Do something
               // Toast.makeText(applicationContext,"start tracking",Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Do something
               // Toast.makeText(applicationContext,"stop tracking",Toast.LENGTH_SHORT).show()
            }
        })


        this.setInformation()
    }





    companion object {
        val EXTRA_VALUE = "EXTRA_VALUE"

        fun createIntent(context: Context, value: Int): Intent {
            return Intent(context, ThirdActivity::class.java).putExtra(EXTRA_VALUE, value)
        }
    }






     // GET MUSIC
     private fun getMusic(){
         this.mediaPlayer = this.musics!![this.index].song

     }








     // HANDLE BUTTONS CLICKS
     private fun  clickMenu(view: View) {

         when(view) {
            prevButton->{
                this.pauseMusic()
                this.index = this.index - 1
                this.setSeek()
                this.getMusic()
                this.startMusic()
                this.setInformation()

            }
            playButton -> {
                this.getMusic()
                if(mediaPlayer?.isPlaying!!) {
                    this.pauseMusic()


                } else {
                    this.startMusic()

                }
            }

            nextButton -> {
                this.pauseMusic()
                this.index = this.index +1
                this.setSeek()
                this.getMusic()
                this.startMusic()
                this.setInformation()

            }

        }
    }






     //Pause Music
   private fun pauseMusic(){
        if (mediaPlayer != null){
           mediaPlayer?.pause()
           playButton?.setBackgroundResource(android.R.drawable.ic_media_play)
        }
    }






     // Start Music
     private fun startMusic() {
        if (mediaPlayer != null){
            mediaPlayer?.start()
            playButton?.setBackgroundResource(android.R.drawable.ic_media_pause)
            this.updateThread()
            this.setInformation()
        }
     }







     // update Thread
     private fun updateThread(){
         seekBar?.setProgress(mediaPlayer?.currentPosition!!)

         if(mediaPlayer?.isPlaying!!){
            var runnable = Runnable {
                 kotlin.run {
                     this.updateThread()
                 }

             }
             handler?.postDelayed(runnable, 1000)

         }

     }






    // Previous Music
     private fun setSeek() {
             mediaPlayer?.seekTo(0)

     }







     // Next Music
     private fun nextMusic() {
        if (mediaPlayer?.isPlaying!!) {
             mediaPlayer?.seekTo(mediaPlayer?.duration!!)
         }
     }








     // Set Title and Session TextView
     private fun setInformation() {
         this.titleMusic?.text = this.musics!![this.index].name
         this.currentSession?.text = "Session : " + (this.musics!![this.index].position +1) + " / " + this.musics?.size

     }


}



