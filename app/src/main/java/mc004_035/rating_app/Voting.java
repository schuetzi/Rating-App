package mc004_035.rating_app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;


public class Voting extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voting);
        addClickListener(getResources().getStringArray(R.array.sorten));
        findViewById(R.id.zurueckVoting).setOnClickListener(this);
        findViewById(R.id.weiterGewinnspiel).setOnClickListener(this);
    }

    private void addClickListener(String[] sorten) {
        String packName = getPackageName(), prefix1 = "ButtonSorte", prefix2 = "RatingBar";
        Resources resources = getResources();
        for (final String sorte: sorten) {
            ImageButton button = (ImageButton) findViewById(
                    resources.getIdentifier(prefix1 + sorte, "id", packName)
            );
            final RatingBar bar = (RatingBar) findViewById(
                    resources.getIdentifier(prefix2 + sorte, "id", packName)
            );
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Voting.this, VotingDetail.class);
                    intent.putExtra("bewertung", bar.getRating());
                    intent.putExtra("sorte", sorte);
                    startActivityForResult(intent, 1);
                }
            });
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        RatingBar bar = (RatingBar) findViewById(getResources().getIdentifier(
                "RatingBar" + intent.getStringExtra("sorte"), "id", getPackageName()));
        bar.setRating(intent.getFloatExtra("bewertung", 0));
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Bewertungen beibehalten?")
                .setMessage("Wie soll mit den vorgenommenen Bewertungen verfahren werden?")
                .setNegativeButton("Verwerfen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        backToHome();
                        finish();
                    }
                })
                .show();
    }

    public void onClick(View v) {
        if (v == findViewById(R.id.zurueckVoting)) {
            onBackPressed();
        } else {
            // startActivity(new Intent(this, VotingSubmit.class));}
        }
    }

    private void backToHome() {
        Intent intent = new Intent(Voting.this, Homescreen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

}