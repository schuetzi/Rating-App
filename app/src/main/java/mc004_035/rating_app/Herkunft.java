package mc004_035.rating_app;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class Herkunft extends Activity implements View.OnClickListener, Animator.AnimatorListener {

    private static final String TAG = "Herkunft";
    ImageButton myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.herkunft);

        Button button = null;
        button = (Button) findViewById(R.id.herkunft_schweine_first_page_button_zurueck);
        button.setOnClickListener(this);

        ImageButton imageButton = null;
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer1_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer2_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer3_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer4_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer5_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer6_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer7_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer8_button);
        imageButton.setOnClickListener(this);
    }

    public void setAnimationFade(int id) {
        myButton = (ImageButton) findViewById(id);
        ObjectAnimator animator = ObjectAnimator.ofFloat(myButton, View.ALPHA, 0.5f, 1f);
        animator.setDuration(300); //ms
        animator.start();
        animator.addListener(this);
    }

    @Override
    public void onAnimationStart(Animator animation) {
        myButton.setAlpha(1f);
    }

    @Override
    public void onClick(View v) {
        TextView text;
        switch (v.getId()) {
            case R.id.herkunft_schweine_bauer1_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer1_button);
                text = (TextView) findViewById(R.id.herkunft_schweine_bauer1_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_schweine_bauer1_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_schweine_bauer2_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer2_button);
                text = (TextView) findViewById(R.id.herkunft_schweine_bauer2_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_schweine_bauer2_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_schweine_bauer3_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer3_button);
                text = (TextView) findViewById(R.id.herkunft_schweine_bauer3_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_schweine_bauer3_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_schweine_bauer4_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer4_button);
                text = (TextView) findViewById(R.id.herkunft_schweine_bauer4_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_schweine_bauer4_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_schweine_bauer5_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer5_button);
                text = (TextView) findViewById(R.id.herkunft_schweine_bauer5_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_schweine_bauer5_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_schweine_bauer6_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer6_button);
                text = (TextView) findViewById(R.id.herkunft_schweine_bauer6_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_schweine_bauer6_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_schweine_bauer7_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer7_button);
                text = (TextView) findViewById(R.id.herkunft_schweine_bauer7_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_schweine_bauer7_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_schweine_bauer8_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer8_button);
                text = (TextView) findViewById(R.id.herkunft_schweine_bauer8_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_schweine_bauer8_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_schweine_first_page_button_zurueck:
                finish();
                break;
            default:
                Log.e(TAG, "Error in getAnimationFade method!");
        }
    }


    @Override
    public void onAnimationEnd(Animator animation) {
        //autogenerated (Animator.AnimatorListener)
    }

    @Override
    public void onAnimationCancel(Animator animation) {
        //autogenerated (Animator.AnimatorListener)
    }

    @Override
    public void onAnimationRepeat(Animator animation) {
        //autogenerated (Animator.AnimatorListener)
    }
}
