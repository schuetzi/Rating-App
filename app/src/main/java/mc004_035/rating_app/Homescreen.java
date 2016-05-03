package mc004_035.rating_app;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;


/**
 * Created by Gabriel on 03.05.16.
 */
public class Homescreen extends Activity {

    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);
        addListenerOnButton();

    }


    private void playVideo() {
        setContentView(R.layout.film); //Change layout
        VideoView videoView = (VideoView) findViewById(R.id.videoView); // search in XML File
        String path = "android.resource://mc004_035.rating_app/" + R.raw.intro; //get path
        Uri pathFixed = Uri.parse(path);
        videoView.setVideoURI(pathFixed);
        MediaController mediaController = new MediaController(Homescreen.this); //get Controllers for movie
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { //wait till video is done
            public void onCompletion(MediaPlayer mp) {
                setContentView(R.layout.homescreen); //change layout back to homescreen
            }
        });
    }


    public void addListenerOnButton() {
        imageButton = (ImageButton) findViewById(R.id.ButtonHomeFilm);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                playVideo();
            }
        });

    }
}
