package mc004_035.rating_app;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;


public class Handling extends Carousel implements View.OnClickListener {

    private static final String TAG = "Handling";
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handling);

        viewFlipper = (ViewFlipper) findViewById(R.id.handling_view_Flipper);

        ImageView imageView = null;

        imageView = (ImageView) findViewById(R.id.handling_var1_next);
        imageView.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.handling_var2_back);
        imageView.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.handling_var2_next);
        imageView.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.handling_var3_back);
        imageView.setOnClickListener(this);

        Button button = null;

        button = (Button) findViewById(R.id.handling_var1_zurueck);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.handling_var2_zurueck);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.handling_var3_zurueck);
        button.setOnClickListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent touch) {
        return super.onTouchEvent(viewFlipper, touch);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.handling_var1_next: {
                viewFlipper.setInAnimation(this, R.anim.slide_in_from_right);
                viewFlipper.setOutAnimation(this, R.anim.slide_out_to_left);
                viewFlipper.showNext();
                break;
            }
            case R.id.handling_var2_back: {
                viewFlipper.setInAnimation(this, R.anim.slide_in_from_left);
                viewFlipper.setOutAnimation(this, R.anim.slide_out_to_right);
                viewFlipper.showPrevious();
                break;
            }

            case R.id.handling_var2_next: {
                viewFlipper.setInAnimation(this, R.anim.slide_in_from_right);
                viewFlipper.setOutAnimation(this, R.anim.slide_out_to_left);
                viewFlipper.showNext();
                break;
            }

            case R.id.handling_var3_back: {
                viewFlipper.setInAnimation(this, R.anim.slide_in_from_left);
                viewFlipper.setOutAnimation(this, R.anim.slide_out_to_right);
                viewFlipper.showPrevious();
                break;
            }
            case R.id.handling_var1_zurueck:
            case R.id.handling_var2_zurueck:
            case R.id.handling_var3_zurueck: {
                finish();
                break;
            }
            default:
                Log.e(TAG, "Error in onClick method!");
        }
    }
}