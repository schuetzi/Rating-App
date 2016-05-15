package mc004_035.rating_app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;

public class Film extends Activity implements MediaPlayer.OnCompletionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film);
        final VideoView videoView = (VideoView) findViewById(R.id.videoView); // search in XML File
        String path = "android.resource://mc004_035.rating_app/" + R.raw.film; //get path
        final Uri pathFixed = Uri.parse(path);
        videoView.setVideoURI(pathFixed);
         //get Controllers for movie
        VideoController videoController = new VideoController(this);
        videoView.setMediaController(videoController);
        videoView.start();
        videoView.setOnCompletionListener(this);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        finish();
    }

    class VideoController extends MediaController implements View.OnClickListener {
        public Button abbrechen;
        public VideoController(Context context) {
            super(context);
        }
        @Override
        public void setAnchorView(View view) {
            VideoController.super.setAnchorView(view);
            abbrechen = new Button(getContext());
            abbrechen.setOnClickListener(this);
            abbrechen.setText("Abbrechen");
            abbrechen.setBackgroundColor(Color.BLACK);
            abbrechen.setTextColor(Color.WHITE);
            abbrechen.setTextSize(20);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.RIGHT;
            addView(abbrechen, params);
        }

        @Override
        public void onClick(View v) {
            finish();
        }


    }


}
