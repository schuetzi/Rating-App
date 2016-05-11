package mc004_035.rating_app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


/**
 * Created by Gabriel on 03.05.16.
 */
public class Homescreen extends Activity {

    ImageButton imageButton;
    private float[] currXandY = new float[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);
        addTouchListenerOnImageButtons(
                new String[]{"ButtonHomeVoting", "ButtonHomeFilm", "ButtonHomeQuality", "ButtonHomeHandling",
                        "ButtonHomeHerkunft", "ButtonHomeReferenzen"},
                new Class[]{Voting.class, Film.class, Qualitaet.class, Handling.class, Herkunft.class,
                        Referenzen.class}
        );
    }

    private void addTouchListenerOnImageButtons(String[] buttonNames, Class[] classes) {
        ImageButton[] buttons = new ImageButton[buttonNames.length];
        String packName = getPackageName();
        Resources resources = getResources();

        ColorMatrix c = new ColorMatrix();
        c.setSaturation(0);
        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(c);

        for (int i = 0; i < buttons.length; ++i) {
            buttons[i] = (ImageButton) findViewById(resources.getIdentifier(buttonNames[i], "id", packName));
            buttons[i].setOnTouchListener(new CustomListener(buttons[i], classes[i], filter));
        }
    }

    private class CustomListener implements View.OnTouchListener {

        final int buttonWidth = 220, buttonHeight = 220;

        ImageButton button;
        Class CLASS;
        ColorMatrixColorFilter filter;
        Matrix matrix;

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
                    startActivity(new Intent(Homescreen.this, CLASS));
                }
            }
            return true;
        }

    }

}
