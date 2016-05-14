package mc004_035.rating_app;

import android.app.Activity;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

/**
 * Created by LSFR77 on 11.05.2016.
 */
public class Carousel extends Activity {

    private float lastX;

    public void addClickListenerOnImageViews(int flipperId, String[] viewNames) {
        String packageName = getPackageName();
        Resources resources = getResources();
        ImageView[] views = new ImageView[viewNames.length];
        for (int i = 0; i < viewNames.length; ++i) {
            views[i] = (ImageView) findViewById(
                    resources.getIdentifier(viewNames[i], "id", packageName)
            );
            views[i].setOnClickListener(new CustomListener(flipperId, viewNames[i], viewNames));
        }
    }

    public void addClickListenerOnButtons(String[] buttonNames) {
        String packageName = getPackageName();
        Resources resources = getResources();
        Button[] buttons = new Button[buttonNames.length];
        for (int i = 0; i < buttons.length; ++i) {
            buttons[i] = (Button) findViewById(
                    resources.getIdentifier(buttonNames[i], "id", packageName)
            );
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    public boolean onTouchEvent(int flipperId, MotionEvent touch) {
        ViewFlipper viewFlipper = (ViewFlipper) findViewById(flipperId);
        switch (touch.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = touch.getX();
                break;
            case MotionEvent.ACTION_UP:
                float currentX = touch.getX();
                // Handling left to right screen swap.
                if (lastX < currentX - 25) {
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
                else if (lastX > currentX + 25) {
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
    }

    private class CustomListener implements View.OnClickListener {

        final int flipperId;
        final String viewName;
        final String[] viewNames;

        CustomListener(int flipperId, String viewName, String[] viewNames) {
            this.flipperId = flipperId;
            this.viewName = viewName;
            this.viewNames = viewNames;
        }

        @Override
        public void onClick(View v) {
            ViewFlipper viewFlipper = (ViewFlipper) findViewById(flipperId);
            if (viewName == viewNames[0] || viewName == viewNames[1]) {
                viewFlipper.setInAnimation(Carousel.this, R.anim.slide_in_from_right);
                viewFlipper.setOutAnimation(Carousel.this, R.anim.slide_out_to_left);
                viewFlipper.showPrevious();
            } else if (viewName == viewNames[2]) {
                viewFlipper.setInAnimation(Carousel.this, R.anim.slide_in_from_far_right);
                viewFlipper.setOutAnimation(Carousel.this, R.anim.slide_out_to_far_left);
                viewFlipper.showNext();
            } else if (viewName == viewNames[3] || viewName == viewNames[5]) {
                viewFlipper.setInAnimation(Carousel.this, R.anim.slide_in_from_left);
                viewFlipper.setOutAnimation(Carousel.this, R.anim.slide_out_to_right);
                viewFlipper.showNext();
            } else if (viewName == viewNames[4] || viewName == viewNames[6]) {
                viewFlipper.setInAnimation(Carousel.this, R.anim.slide_in_from_right);
                viewFlipper.setOutAnimation(Carousel.this, R.anim.slide_out_to_left);
                viewFlipper.showPrevious();
            } else if (viewName == viewNames[7] || viewName == viewNames[9]) {
                viewFlipper.setInAnimation(Carousel.this, R.anim.slide_in_from_left);
                viewFlipper.setOutAnimation(Carousel.this, R.anim.slide_out_to_right);
                viewFlipper.showNext();
            } else if (viewName == viewNames[8]) {
                viewFlipper.setInAnimation(Carousel.this, R.anim.slide_in_from_far_left);
                viewFlipper.setOutAnimation(Carousel.this, R.anim.slide_out_to_far_right);
                viewFlipper.showPrevious();
            }
        }

    }

}