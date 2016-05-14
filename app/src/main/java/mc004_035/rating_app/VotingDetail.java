package mc004_035.rating_app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by LSFR77 on 13.05.2016.
 */
public class VotingDetail extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voting_detail);
        Resources resources = getResources();
        String packageName = getPackageName();
        Intent intent = getIntent();
        final float bewertung = intent.getFloatExtra("bewertung", 0);
        final String sorte = getIntent().getStringExtra("sorte");
        StringBuffer buffer = new StringBuffer(sorte);

        buffer.setCharAt(0, Character.toLowerCase(buffer.charAt(0)));
        int length = buffer.length();
        for (int i = 0; i < length; ++i)
            if (buffer.charAt(i) == Character.toUpperCase(buffer.charAt(i))) {
                buffer.setCharAt(i, Character.toLowerCase(buffer.charAt(i)));
                buffer.insert(i, '_');
                ++i;
            }
        String drawable = buffer.toString();

        findViewById(R.id.ButtonSorteDetail).setBackgroundResource(
                resources.getIdentifier(drawable, "drawable", packageName)
        );
        ((TextView) findViewById(R.id.SorteBeschreibung)).setText(
                resources.getIdentifier("Beschreibung" + sorte, "string", packageName)
        );
        final RatingBar bar = (RatingBar) findViewById(R.id.RatingBarDetail);
        bar.setRating(bewertung);

        findViewById(R.id.fertigVoting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("bewertung", bar.getRating());
                intent.putExtra("sorte", sorte);
                setResult(0, intent);
                finish();
            }
        });
    }

}