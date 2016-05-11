package mc004_035.rating_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by LSFR77 on 10.05.2016.
 */
public class Qualitaet extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qualitaet);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
