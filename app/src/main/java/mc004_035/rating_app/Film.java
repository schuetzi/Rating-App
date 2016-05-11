package mc004_035.rating_app;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by LSFR77 on 10.05.2016.
 */
public class Film extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film);
        final VideoView videoView = (VideoView) findViewById(R.id.videoView); // search in XML File
        String path = "android.resource://mc004_035.rating_app/" + R.raw.film; //get path
        final Uri pathFixed = Uri.parse(path);
        videoView.setVideoURI(pathFixed);
        MediaController mediaController = new MediaController(this); //get Controllers for movie
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { //wait till video is done
            public void onCompletion(MediaPlayer mp) {
                finish(); // return to homescreen
            }
        });
    }

}
