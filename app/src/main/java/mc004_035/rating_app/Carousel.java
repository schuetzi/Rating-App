package mc004_035.rating_app;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;


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

    public void setTextVisible(View v) {
        TextView text;
        StringBuffer id = new StringBuffer();
        id.append(getResources().getResourceName(v.getId()));
        id.delete(id.length() - 6, id.length());
        id.append("name");
        text = (TextView) findViewById(getResources().getIdentifier(id.toString(), "id", getPackageName()));
        text.setVisibility(View.VISIBLE);
        id.delete(id.length() - 4, id.length());
        id.append("ort");
        text = (TextView) findViewById(getResources().getIdentifier(id.toString(), "id", getPackageName()));
        text.setVisibility(View.VISIBLE);
    }

//    public void attachToButton(View root, View.OnClickListener listener) {
//        ArrayList<View> elements = root.getTouchables();
//        for (View v : elements) {
//            if (v instanceof Button) {
//                Button b = (Button) v;
//                b.setOnClickListener(listener);
//            }
//        }
//    }
//
//    public void attachToImageButton(View root, View.OnClickListener listener) {
//        ArrayList<View> elements = root.getTouchables();
//        for (View v : elements) {
//            if (v instanceof ImageButton) {
//                ImageButton imageButton = (ImageButton) v;
//                imageButton.setOnClickListener(listener);
//            }
//        }
//    }
//
//    public void attachToImageView(View root, View.OnClickListener listener) {
//        ArrayList<View> elements = root.getTouchables();
//        for (View v : elements) {
//            if (v instanceof ImageView) {
//                ImageView imageView = (ImageView) v;
//                imageView.setOnClickListener(listener);
//            }
//        }
//    }

}