package mc004_035.rating_app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.ViewFlipper;


/**
 * Created by Gabriel on 03.05.16.
 */
public class Homescreen extends Activity {

    ImageButton imageButton;
    private ViewFlipper viewFlipper;
    private float lastX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);

    }

    public void playVideo(View v) {
        setContentView(R.layout.film); //Change layout
        final VideoView videoView = (VideoView) findViewById(R.id.videoView); // search in XML File
        String path = "android.resource://mc004_035.rating_app/" + R.raw.film; //get path
        final Uri pathFixed = Uri.parse(path);
        videoView.setVideoURI(pathFixed);
        MediaController mediaController = new MediaController(Homescreen.this); //get Controllers for movie
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { //wait till video is done
            public void onCompletion(MediaPlayer mp) {
                finish();
                startActivity(getIntent()); // return to homescreen
            }
        });
    }

    public void showHerkunft(View v) {
        setContentView(R.layout.herkunft);
    }

    public void getHomescreen(View v) {
        setContentView(R.layout.homescreen);
    }

    public void getQualitaet(View v) {
        setContentView(R.layout.qualitaet);
    }

    public void getHandling(View v) {
        setContentView(R.layout.handling);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
    }

    public void getReferenzen(View v) {
        setContentView(R.layout.referenzen);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewSecondFlipper);
    }

    public void setAnimationFade(View v, int id) {
        final ImageButton myButton = (ImageButton) findViewById(id);
        ObjectAnimator animator = ObjectAnimator.ofFloat(myButton, View.ALPHA, 0.5f, 1f);
        animator.setDuration(300); //msx
        animator.start();
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                myButton.setAlpha(1f);
            }
        });
    }

    public void getAnimationFade(View v) {
        TextView text;
        switch (v.getId()) {
            case R.id.ButtonBauer1:
                setAnimationFade(v, v.getId());
                text = (TextView) findViewById(R.id.NameBauer1);
                text.setVisibility(v.VISIBLE);
                text = (TextView) findViewById(R.id.OrtBauer1);
                text.setVisibility(v.VISIBLE);
                break;
            case R.id.ButtonBauer2:
                setAnimationFade(v, v.getId());
                text = (TextView) findViewById(R.id.NameBauer2);
                text.setVisibility(v.VISIBLE);
                text = (TextView) findViewById(R.id.OrtBauer2);
                text.setVisibility(v.VISIBLE);
                break;
            case R.id.ButtonBauer3:
                setAnimationFade(v, v.getId());
                text = (TextView) findViewById(R.id.NameBauer3);
                text.setVisibility(v.VISIBLE);
                text = (TextView) findViewById(R.id.OrtBauer3);
                text.setVisibility(v.VISIBLE);
                break;
            case R.id.ButtonBauer4:
                setAnimationFade(v, v.getId());
                text = (TextView) findViewById(R.id.NameBauer4);
                text.setVisibility(v.VISIBLE);
                text = (TextView) findViewById(R.id.OrtBauer4);
                text.setVisibility(v.VISIBLE);
                break;
            case R.id.ButtonBauer5:
                setAnimationFade(v, v.getId());
                text = (TextView) findViewById(R.id.NameBauer5);
                text.setVisibility(v.VISIBLE);
                text = (TextView) findViewById(R.id.OrtBauer5);
                text.setVisibility(v.VISIBLE);
                break;
            case R.id.ButtonBauer6:
                setAnimationFade(v, v.getId());
                text = (TextView) findViewById(R.id.NameBauer6);
                text.setVisibility(v.VISIBLE);
                text = (TextView) findViewById(R.id.OrtBauer6);
                text.setVisibility(v.VISIBLE);
                break;
            case R.id.ButtonBauer7:
                setAnimationFade(v, v.getId());
                text = (TextView) findViewById(R.id.NameBauer7);
                text.setVisibility(v.VISIBLE);
                text = (TextView) findViewById(R.id.OrtBauer7);
                text.setVisibility(v.VISIBLE);
                break;
            case R.id.ButtonBauer8:
                setAnimationFade(v, v.getId());
                text = (TextView) findViewById(R.id.NameBauer8);
                text.setVisibility(v.VISIBLE);
                text = (TextView) findViewById(R.id.OrtBauer8);
                text.setVisibility(v.VISIBLE);
                break;
        }
    }

    /*public boolean onTouchEvent(MotionEvent touch) {
        switch (touch.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = touch.getX();
                break;
            case MotionEvent.ACTION_UP:
                float currentX = touch.getX();
                // Handling left to right screen swap.
                if (lastX < currentX) {
                    // If there aren't any other children, just break.
                    if (viewFlipper.getDisplayedChild() == 0)
                    break;
                    // Next screen comes in from left.
                    viewFlipper.setInAnimation(this, R.anim.slide_in_from_left);
                    // Current screen goes out from right.
                    viewFlipper.setOutAnimation(this, R.anim.slide_out_to_right);
                    // Display next screen.
                    viewFlipper.showNext();
                }
                // Handling right to left screen swap.
                if (lastX > currentX) {
                    // If there is a child (to the left), just break.
                    if (viewFlipper.getDisplayedChild() == 1)
                    break;
                    // Next screen comes in from right.
                    viewFlipper.setInAnimation(this, R.anim.slide_in_from_right);
                    // Current screen goes out from left.
                    viewFlipper.setOutAnimation(this, R.anim.slide_out_to_left);
                    // Display previous screen.
                    viewFlipper.showPrevious();
                }
                break;
        }
        return false;
    }*/



}
