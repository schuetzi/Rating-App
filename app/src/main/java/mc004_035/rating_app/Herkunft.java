package mc004_035.rating_app;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class Herkunft extends Carousel implements View.OnClickListener {

    private static final String TAG = "Herkunft";
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.herkunft);

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
        imageView = (ImageView) findViewById(R.id.herkunft_schweine_third_page_next);
        imageView.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.herkunft_rinder_first_page_back);
        imageView.setOnClickListener(this);


        ImageButton button = null;
        button = (ImageButton) findViewById(R.id.herkunft_schweine_first_page_button_zurueck);
        button.setOnClickListener(this);
        button = (ImageButton) findViewById(R.id.herkunft_schweine_sec_page_button_zurueck);
        button.setOnClickListener(this);
        button = (ImageButton) findViewById(R.id.herkunft_schweine_third_page_button_zurueck);
        button.setOnClickListener(this);
        button = (ImageButton) findViewById(R.id.herkunft_rinder_first_page_button_zurueck);
        button.setOnClickListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent touch) {
        return super.onTouchEvent(viewFlipper, touch);
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
            case R.id.herkunft_schweine_third_page_next: {
                viewFlipper.setInAnimation(this, R.anim.slide_in_from_right);
                viewFlipper.setOutAnimation(this, R.anim.slide_out_to_left);
                viewFlipper.showNext();
                break;
            }
            case R.id.herkunft_rinder_first_page_back: {
                viewFlipper.setInAnimation(this, R.anim.slide_in_from_left);
                viewFlipper.setOutAnimation(this, R.anim.slide_out_to_right);
                viewFlipper.showPrevious();
                break;
            }

            case R.id.herkunft_schweine_first_page_button_zurueck:
            case R.id.herkunft_schweine_sec_page_button_zurueck:
            case R.id.herkunft_schweine_third_page_button_zurueck:
            case R.id.herkunft_rinder_first_page_button_zurueck:
                finish();
                break;
            default:
                Log.e(TAG, "Error in onClick method!");
                break;

        }
    }
}
