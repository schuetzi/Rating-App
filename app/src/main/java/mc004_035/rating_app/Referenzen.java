package mc004_035.rating_app;

import android.os.Bundle;
import android.view.MotionEvent;

/**
 * Created by LSFR77 on 10.05.2016.
 */
public class Referenzen extends Carousel {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.referenzen);
        super.addClickListenerOnImageViews(
                R.id.viewSecondFlipper, new String[]{
                        "firstPicNext", "firstPicSecBullet", "firstPicThirdBullet",
                        "secPicBack", "secPicNext", "secPicFirstBullet", "secPicThirdBullet",
                        "thirdPicBack", "thirdPicFirstBullet", "thirdPicSecBullet"
                }
        );
        super.addClickListenerOnButtons(new String[]{"button2", "button3", "button4"});
    }

    @Override
    public boolean onTouchEvent(MotionEvent touch) {
        return super.onTouchEvent(R.id.viewSecondFlipper, touch);
    }

}