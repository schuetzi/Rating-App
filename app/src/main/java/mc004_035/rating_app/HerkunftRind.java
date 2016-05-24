package mc004_035.rating_app;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class HerkunftRind extends Carousel implements View.OnClickListener, Animator.AnimatorListener {

    private static final String TAG = "HerkunftRind";
    ViewFlipper viewFlipper;
    ImageButton myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.herkunft_rind);

        viewFlipper = (ViewFlipper) findViewById(R.id.herkunft_rinder_view_flipper);

        ImageView imageView = null;

        imageView = (ImageView) findViewById(R.id.herkunft_rinder_first_page_next);
        imageView.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.herkunft_rinder_sec_page_back);
        imageView.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.herkunft_rinder_sec_page_next);
        imageView.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.herkunft_rinder_third_page_back);
        imageView.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.herkunft_rinder_third_page_next);
        imageView.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.herkunft_rinder_fourth_page_back);
        imageView.setOnClickListener(this);

        ImageButton imageButton = null;
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer1_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer2_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer3_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer4_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer5_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer6_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer7_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer8_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer9_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer10_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer11_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer12_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer13_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer14_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer15_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer16_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer17_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer18_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer19_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer20_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer21_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer22_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer23_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer24_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer25_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer26_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer27_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer28_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer29_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_rinder_bauer30_button);
        imageButton.setOnClickListener(this);

        Button button = null;
        button = (Button) findViewById(R.id.herkunft_rinder_first_page_button_zurueck);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.herkunft_rinder_sec_page_button_zurueck);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.herkunft_rinder_third_page_button_zurueck);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.herkunft_rinder_fourth_page_button_zurueck);
        button.setOnClickListener(this);


    }


    @Override
    public boolean onTouchEvent(MotionEvent touch) {
        return super.onTouchEvent(viewFlipper, touch);
    }

    public void setAnimationFade(int id, View v) {
        myButton = (ImageButton) findViewById(id);
        ObjectAnimator animator = ObjectAnimator.ofFloat(myButton, View.ALPHA, 0.5f, 1f);
        animator.setDuration(300); //ms
        animator.start();
        animator.addListener(this);
        setTextVisible(v);
    }

    public void setTextVisible(View v) {
        super.setTextVisible(v);
    }
    
    @Override
    public void onAnimationStart(Animator animation) {
        myButton.setAlpha(1f);
    }

    @Override
    public void onClick(View v) {
        TextView text;
        switch (v.getId()) {
            case R.id.herkunft_rinder_first_page_next: {
                viewFlipper.setInAnimation(this, R.anim.slide_in_from_right);
                viewFlipper.setOutAnimation(this, R.anim.slide_out_to_left);
                viewFlipper.showNext();
                break;
            }
            case R.id.herkunft_rinder_sec_page_back: {
                viewFlipper.setInAnimation(this, R.anim.slide_in_from_left);
                viewFlipper.setOutAnimation(this, R.anim.slide_out_to_right);
                viewFlipper.showPrevious();
                break;
            }

            case R.id.herkunft_rinder_sec_page_next: {
                viewFlipper.setInAnimation(this, R.anim.slide_in_from_right);
                viewFlipper.setOutAnimation(this, R.anim.slide_out_to_left);
                viewFlipper.showNext();
                break;
            }
            case R.id.herkunft_rinder_third_page_back: {
                viewFlipper.setInAnimation(this, R.anim.slide_in_from_left);
                viewFlipper.setOutAnimation(this, R.anim.slide_out_to_right);
                viewFlipper.showPrevious();
                break;
            }
            case R.id.herkunft_rinder_third_page_next: {
                viewFlipper.setInAnimation(this, R.anim.slide_in_from_right);
                viewFlipper.setOutAnimation(this, R.anim.slide_out_to_left);
                viewFlipper.showNext();
                break;
            }
            case R.id.herkunft_rinder_fourth_page_back: {
                viewFlipper.setInAnimation(this, R.anim.slide_in_from_left);
                viewFlipper.setOutAnimation(this, R.anim.slide_out_to_right);
                viewFlipper.showPrevious();
                break;
            }
            case R.id.herkunft_rinder_bauer1_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer1_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer2_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer2_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer3_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer3_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer4_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer4_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer5_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer5_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer6_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer6_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer7_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer7_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer8_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer8_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer9_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer9_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer10_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer10_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer11_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer11_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer12_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer12_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer13_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer13_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer14_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer14_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer15_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer15_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer16_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer16_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer17_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer17_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer18_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer18_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer19_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer19_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer20_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer20_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer21_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer21_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer22_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer22_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer23_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer23_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer24_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer24_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer25_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer25_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer26_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer26_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer27_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer27_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer28_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer28_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer29_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer29_button, v);
                break;
            }
            case R.id.herkunft_rinder_bauer30_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer30_button, v);
                break;
            }
            case R.id.herkunft_rinder_first_page_button_zurueck:
            case R.id.herkunft_rinder_sec_page_button_zurueck:
            case R.id.herkunft_rinder_third_page_button_zurueck:
            case R.id.herkunft_rinder_fourth_page_button_zurueck:
                finish();
                break;
            default:
                Log.e(TAG, "Error in onClick method!");
                break;

        }

    }


    @Override
    public void onAnimationEnd(Animator animation) {

    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }

}
