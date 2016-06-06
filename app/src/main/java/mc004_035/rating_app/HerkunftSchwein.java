package mc004_035.rating_app;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class HerkunftSchwein extends Carousel implements View.OnClickListener, Animator.AnimatorListener {

    private static final String TAG = "HerkunftSchwein";
    ViewFlipper viewFlipper;
    ImageButton myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.herkunft_schwein);

        viewFlipper = (ViewFlipper) findViewById(R.id.herkunft_schweine_view_flipper);

        ImageView imageView = null;

        imageView = (ImageView) findViewById(R.id.herkunft_schweine_first_page_next);
        imageView.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.herkunft_schweine_sec_page_back);
        imageView.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.herkunft_schweine_sec_page_next);
        imageView.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.herkunft_schweine_third_page_back);
        imageView.setOnClickListener(this);

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
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer9_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer10_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer11_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer12_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer13_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer14_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer15_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer16_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer17_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer18_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer19_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer20_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer21_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer22_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer23_button);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_schweine_bauer24_button);
        imageButton.setOnClickListener(this);

        Button button = null;
        button = (Button) findViewById(R.id.herkunft_schweine_first_page_button_zurueck);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.herkunft_schweine_sec_page_button_zurueck);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.herkunft_schweine_third_page_button_zurueck);
        button.setOnClickListener(this);
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
        TextView text;
        StringBuffer id = new StringBuffer();
        id.append(getResources().getResourceName(v.getId()));
        id.delete(id.length() - 6, id.length());
        id.append("name");
        text = (TextView) findViewById(getResources().getIdentifier(id.toString(),"id", getPackageName()));
        text.setVisibility(View.VISIBLE);
        id.delete(id.length() - 4, id.length());
        id.append("ort");
        text = (TextView) findViewById(getResources().getIdentifier(id.toString(),"id", getPackageName()));
        text.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAnimationStart(Animator animation) {
        myButton.setAlpha(1f);
    }


    @Override
    public void onClick(View v) {
        TextView text;
        switch (v.getId()) {
            case R.id.herkunft_schweine_first_page_next: {
                viewFlipper.setInAnimation(this, R.anim.slide_in_from_right);
                viewFlipper.setOutAnimation(this, R.anim.slide_out_to_left);
                viewFlipper.showNext();
                break;
            }
            case R.id.herkunft_schweine_sec_page_back: {
                viewFlipper.setInAnimation(this, R.anim.slide_in_from_left);
                viewFlipper.setOutAnimation(this, R.anim.slide_out_to_right);
                viewFlipper.showPrevious();
                break;
            }

            case R.id.herkunft_schweine_sec_page_next: {
                viewFlipper.setInAnimation(this, R.anim.slide_in_from_right);
                viewFlipper.setOutAnimation(this, R.anim.slide_out_to_left);
                viewFlipper.showNext();
                break;
            }

            case R.id.herkunft_schweine_third_page_back: {
                viewFlipper.setInAnimation(this, R.anim.slide_in_from_left);
                viewFlipper.setOutAnimation(this, R.anim.slide_out_to_right);
                viewFlipper.showPrevious();
                break;
            }
            case R.id.herkunft_schweine_bauer1_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer1_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer2_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer2_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer3_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer3_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer4_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer4_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer5_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer5_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer6_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer6_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer7_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer7_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer8_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer8_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer9_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer9_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer10_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer10_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer11_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer11_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer12_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer12_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer13_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer13_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer14_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer14_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer15_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer15_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer16_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer16_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer17_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer17_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer18_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer18_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer19_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer19_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer20_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer20_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer21_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer21_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer22_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer22_button, v);
                break;
            }
            case R.id.herkunft_schweine_bauer23_button: {
                break;
            }
            case R.id.herkunft_schweine_bauer24_button: {
                setAnimationFade(R.id.herkunft_schweine_bauer24_button, v);
                break;
            }
            case R.id.herkunft_schweine_first_page_button_zurueck:
            case R.id.herkunft_schweine_sec_page_button_zurueck:
            case R.id.herkunft_schweine_third_page_button_zurueck:
                finish();
                break;
            default:
                Log.e(TAG, "Error in onClick method!");
                break;

        }
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        //autogenerated
    }

    @Override
    public void onAnimationCancel(Animator animation) {
        //autogenerated
    }

    @Override
    public void onAnimationRepeat(Animator animation) {
        //autogenerated
    }
}