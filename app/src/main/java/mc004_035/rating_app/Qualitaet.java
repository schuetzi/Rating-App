package mc004_035.rating_app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Qualitaet extends Activity implements View.OnClickListener {

    private final static String TAG = "Qualitaet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qualitaet);

        Button button = null;

        button = (Button) findViewById(R.id.qualitaet_button_zurueck);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.qualitaet_button_zurueck: {
                finish();
                break;
            }
            default:
                Log.e(TAG, "Error onClick!");
        }
    }
}
