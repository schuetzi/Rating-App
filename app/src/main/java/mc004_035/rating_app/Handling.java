package mc004_035.rating_app;

import android.os.Bundle;
import android.view.MotionEvent;

/**
 * Created by LSFR77 on 10.05.2016.
 */
public class Handling extends Carousel {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handling);
        super.addClickListenerOnImageViews(
                R.id.viewFlipper, new String[]{
                        "firstVarNext", "firstVarSecBullet", "firstVarThirdBullet",
                        "secVarBack", "secVarNext", "secVarFirstBullet", "secVarThirdBullet",
                        "thirdVarBack", "thirdVarFirstBullet", "thirdVarSecBullet"
                }
        );
        super.addClickListenerOnButtons(new String[]{"button5", "button6", "button7"});
    }

    @Override
    public boolean onTouchEvent(MotionEvent touch) {
        return super.onTouchEvent(R.id.viewFlipper, touch);
    }

}