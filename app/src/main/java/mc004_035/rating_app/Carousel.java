package mc004_035.rating_app;

import android.app.Activity;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;


public class Carousel extends Activity {

    private float lastX;

    public boolean onTouchEvent(ViewFlipper viewFlipper, MotionEvent touch) {
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
}