package mc004_035.rating_app;

import android.app.Activity;
import android.view.MotionEvent;
import android.widget.ViewFlipper;


public class Carousel extends Activity {

    private float lastX;

    public boolean onTouchEvent(ViewFlipper vf, MotionEvent touchevent) {

        switch (touchevent.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                lastX = touchevent.getX();

                break;
            }
            case MotionEvent.ACTION_UP: {
                float currentX = touchevent.getX();
                if (lastX == currentX)
                    break;
                // Handling left to right screen swap.
                if (lastX < currentX - 25) {
                    if (vf.getDisplayedChild() == 0)
                        // If there aren't any other children, just break.
                        break;
                    // Next screen comes in from left.
                    vf.setInAnimation(this, R.anim.slide_in_from_left);
                    // Current screen goes out from left.
                    vf.setOutAnimation(this, R.anim.slide_out_to_right);
                    // Display next screen.
                    vf.showPrevious();
                }
                // Handling right to left screen swap.
                if (lastX > currentX - 25) {
                    if (vf.getDisplayedChild() == vf.getChildCount() - 1)
                        // If there is a child (to the left), just break.
                        break;
                    // Next screen comes in from right.
                    vf.setInAnimation(this, R.anim.slide_in_from_right);
                    // Current screen goes out from left.
                    vf.setOutAnimation(this, R.anim.slide_out_to_left);
                    // Display previous screen.
                    vf.showNext();
                }
                break;
            }
        }
        return false;
    }
}