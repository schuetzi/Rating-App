package mc004_035.rating_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HerkunftMenu extends Activity implements View.OnClickListener{

    private final static String TAG = "HerkunftMenu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.herkunft_menu);

        ImageButton imageButton = null;
        imageButton = (ImageButton) findViewById(R.id.herkunft_menu_button_rind);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.herkunft_menu_button_schwein);
        imageButton.setOnClickListener(this);

        Button button = null;
        button = (Button) findViewById(R.id.herkunft_menu_button_zurueck);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.herkunft_menu_button_rind: {
                i = new Intent(this, HerkunftRind.class);
                startActivity(i);
                break;
            }
            case R.id.herkunft_menu_button_schwein: {
                i = new Intent(this, HerkunftSchwein.class);
                startActivity(i);
                break;
            }
            case R.id.herkunft_menu_button_zurueck: {
                finish();
                break;
            }
            default:
                Log.e(TAG, "Error in onClick method!");
        }
    }
}
