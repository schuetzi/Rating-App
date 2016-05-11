package mc004_035.rating_app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
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
        int id = v.getId();
        TextView text;
        setAnimationFade(v, id);
        switch (id) {
            case R.id.ButtonBauer1:
                text = (TextView) findViewById(R.id.NameBauer1);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.OrtBauer1);
                text.setVisibility(View.VISIBLE);
                break;
            case R.id.ButtonBauer2:
                text = (TextView) findViewById(R.id.NameBauer2);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.OrtBauer2);
                text.setVisibility(View.VISIBLE);
                break;
            case R.id.ButtonBauer3:
                text = (TextView) findViewById(R.id.NameBauer3);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.OrtBauer3);
                text.setVisibility(View.VISIBLE);
                break;
            case R.id.ButtonBauer4:
                text = (TextView) findViewById(R.id.NameBauer4);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.OrtBauer4);
                text.setVisibility(View.VISIBLE);
                break;
            case R.id.ButtonBauer5:
                text = (TextView) findViewById(R.id.NameBauer5);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.OrtBauer5);
                text.setVisibility(View.VISIBLE);
                break;
            case R.id.ButtonBauer6:
                text = (TextView) findViewById(R.id.NameBauer6);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.OrtBauer6);
                text.setVisibility(View.VISIBLE);
                break;
            case R.id.ButtonBauer7:
                text = (TextView) findViewById(R.id.NameBauer7);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.OrtBauer7);
                text.setVisibility(View.VISIBLE);
                break;
            case R.id.ButtonBauer8:
                text = (TextView) findViewById(R.id.NameBauer8);
                text.setVisibility(View.VISIBLE);
                text = (TextView) findViewById(R.id.OrtBauer8);
                text.setVisibility(View.VISIBLE);
        }
    }

}
