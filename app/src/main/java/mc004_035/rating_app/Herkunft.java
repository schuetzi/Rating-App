package mc004_035.rating_app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by LSFR77 on 10.05.2016.
 */
public class Herkunft extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.herkunft);
        findViewById(R.id.angry_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void setAnimationFade(View v, int id) {
        final ImageButton myButton = (ImageButton) findViewById(id);
        ObjectAnimator animator = ObjectAnimator.ofFloat(myButton, View.ALPHA, 0.5f, 1f);
        animator.setDuration(300); //msx
        animator.start();
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                myButton.setAlpha(1f);
            }
        });
    }

    public void getAnimationFade(View v) {
        String packageName = getPackageName();
        Resources resources = getResources();
        TextView text;
        setAnimationFade(v, v.getId());
        int i = 1;
        while (v != findViewById(resources.getIdentifier("ButtonBauer" + i, "id", packageName)))
            ++i;
        text = (TextView) findViewById(resources.getIdentifier("NameBauer" + i, "id", packageName));
        text.setVisibility(View.VISIBLE);
        text = (TextView) findViewById(resources.getIdentifier("OrtBauer" + i, "id", packageName));
        text.setVisibility(View.VISIBLE);
    }

}
