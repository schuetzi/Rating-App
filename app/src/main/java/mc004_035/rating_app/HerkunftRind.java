package mc004_035.rating_app;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class HerkunftRind extends Activity implements View.OnClickListener, Animator.AnimatorListener {

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

    public void setAnimationFade(int id) {
        myButton = (ImageButton) findViewById(id);
        ObjectAnimator animator = ObjectAnimator.ofFloat(myButton, View.ALPHA, 0.5f, 1f);
        animator.setDuration(300); //ms
        animator.start();
        animator.addListener(this);
    }

    public void setTextVisible() {

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
                setAnimationFade(R.id.herkunft_rinder_bauer1_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer1_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer1_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer2_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer2_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer2_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer2_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer3_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer3_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer3_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer3_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer4_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer4_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer4_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer4_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer5_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer5_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer5_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer5_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer6_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer6_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer6_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer6_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer7_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer7_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer7_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer7_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer8_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer8_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer8_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer8_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer9_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer9_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer9_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer9_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer10_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer10_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer10_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer10_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer11_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer11_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer11_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer11_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer12_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer12_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer12_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer12_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer13_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer13_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer13_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer13_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer14_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer14_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer14_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer14_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer15_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer15_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer15_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer15_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer16_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer16_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer16_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer16_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer17_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer17_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer17_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer17_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer18_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer18_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer18_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer18_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer19_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer19_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer19_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer19_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer20_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer20_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer20_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer20_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer21_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer21_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer21_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer21_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer22_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer22_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer22_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer22_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer23_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer23_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer23_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer23_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer24_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer24_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer24_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer24_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer25_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer25_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer25_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer25_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer26_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer26_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer26_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer26_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer27_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer27_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer27_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer27_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer28_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer28_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer28_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer28_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer29_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer29_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer29_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer29_ort);
                text.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.herkunft_rinder_bauer30_button: {
                setAnimationFade(R.id.herkunft_rinder_bauer30_button);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer30_name);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.herkunft_rinder_bauer30_ort);
                text.setVisibility(View.VISIBLE);
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
