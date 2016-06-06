package mc004_035.rating_app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


public class Homescreen extends Activity {

    ImageButton imageButton;
    private final float[] currXandY = new float[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);


        ColorMatrix c = new ColorMatrix();
        c.setSaturation(0);
        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(c);

        ImageButton imageButton = null;

        imageButton = (ImageButton) findViewById(R.id.homescreen_button_voting);
        imageButton.setOnTouchListener(new CustomListener((ImageButton) findViewById(R.id.homescreen_button_voting), Voting.class, filter));
        imageButton = (ImageButton) findViewById(R.id.homescreen_button_qualitaet);
        imageButton.setOnTouchListener(new CustomListener((ImageButton) findViewById(R.id.homescreen_button_qualitaet), Qualitaet.class, filter));
        imageButton = (ImageButton) findViewById(R.id.homescreen_button_handling);
        imageButton.setOnTouchListener(new CustomListener((ImageButton) findViewById(R.id.homescreen_button_handling), Handling.class, filter));
        imageButton = (ImageButton) findViewById(R.id.homescreen_button_herkunft);
        imageButton.setOnTouchListener(new CustomListener((ImageButton) findViewById(R.id.homescreen_button_herkunft), HerkunftMenu.class, filter));
        imageButton = (ImageButton) findViewById(R.id.homescreen_button_film);
        imageButton.setOnTouchListener(new CustomListener((ImageButton) findViewById(R.id.homescreen_button_film), Film.class, filter));
        imageButton = (ImageButton) findViewById(R.id.homescreen_button_referenzen);
        imageButton.setOnTouchListener(new CustomListener((ImageButton) findViewById(R.id.homescreen_button_referenzen), Referenzen.class, filter));
    }

    private class CustomListener implements View.OnTouchListener {

        final int buttonWidth = 220, buttonHeight = 220;

        final ImageButton button;
        final Class CLASS;
        final ColorMatrixColorFilter filter;
        final Matrix matrix;

        CustomListener(ImageButton button, Class CLASS, ColorMatrixColorFilter filter) {
            this.button = button;
            this.CLASS = CLASS;
            this.filter = filter;

            matrix = new Matrix();
            Drawable buttonDrawable = button.getDrawable();
            float scaleXFactor = buttonWidth / (float) buttonDrawable.getIntrinsicWidth() * 0.975f,
                    scaleYFactor = buttonHeight / (float) buttonDrawable.getIntrinsicHeight() * 0.975f,
                    upperLeftX = buttonWidth * (1 - 0.975f) / 2.f,
                    upperLeftY = buttonHeight * (1 - 0.975f) / 2.f;
            matrix.setScale(scaleXFactor, scaleYFactor, upperLeftX, upperLeftY);
        }

        @Override
        public boolean onTouch(View v, MotionEvent ev) {
            int evAction = ev.getAction();
            if (evAction == MotionEvent.ACTION_DOWN) {
                button.setColorFilter(filter);
                button.setScaleType(ImageView.ScaleType.MATRIX);
                button.setImageMatrix(matrix);
                currXandY[0] = ev.getX();
                currXandY[1] = ev.getY();
            } else if (evAction == MotionEvent.ACTION_UP) {
                button.clearColorFilter();
                button.setScaleType(ImageView.ScaleType.FIT_CENTER);
                if (Math.abs(ev.getX() - currXandY[0]) < 10 &&
                        Math.abs(ev.getY() - currXandY[1]) < 10) {
                    Intent intent = new Intent(Homescreen.this, CLASS);
                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(intent);
                }
            }
            return true;
        }
    }
}