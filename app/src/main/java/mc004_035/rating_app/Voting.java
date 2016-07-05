package mc004_035.rating_app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.Arrays;


public class Voting extends Activity implements View.OnClickListener {

    static int currView = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voting);
        ViewFlipper flipper = (ViewFlipper) findViewById(R.id.VotingFlipper);
        if (currView == 2)
            flipper.showNext();
        else if (currView == 3)
            flipper.showPrevious();
        addClickListeners(getResources().getStringArray(R.array.sorten));
        findViewById(R.id.zurueck_Voting_1).setOnClickListener(this);
        findViewById(R.id.zurueck_Voting_2).setOnClickListener(this);
        findViewById(R.id.zurueck_Voting_3).setOnClickListener(this);
        findViewById(R.id.weiter_Gewinnspiel_1).setOnClickListener(this);
        findViewById(R.id.weiter_Gewinnspiel_2).setOnClickListener(this);
        findViewById(R.id.weiter_Gewinnspiel_3).setOnClickListener(this);
    }

    private void addClickListeners(String[] sorten) {
        String packName = getPackageName(), prefix1 = "ButtonSorte", prefix2 = "RatingBar";
        Resources resources = getResources();
        for (final String sorte: sorten) {
            final ImageButton button = (ImageButton) findViewById(
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
            bar.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent ev) {
                    if (ev.getAction() == MotionEvent.ACTION_UP)
                        button.performClick();
                    return true;
                }
            });
        }
        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewFlipper flipper = (ViewFlipper) findViewById(R.id.VotingFlipper);
                switch (v.getId()) {
                    case R.id.ButtonLeberkaese:
                        if (currView == 2) {
                            flipper.setInAnimation(Voting.this, R.anim.slide_in_from_left);
                            flipper.setOutAnimation(Voting.this, R.anim.slide_out_to_right);
                            flipper.showPrevious();
                        } else if (currView == 3) {
                            flipper.setInAnimation(Voting.this, R.anim.slide_in_from_far_left);
                            flipper.setOutAnimation(Voting.this, R.anim.slide_out_to_far_right);
                            flipper.showNext();
                        }
                        currView = 1;
                        break;
                    case R.id.ButtonWuerstel:
                        if (currView == 1) {
                            flipper.setInAnimation(Voting.this, R.anim.slide_in_from_right);
                            flipper.setOutAnimation(Voting.this, R.anim.slide_out_to_left);
                            flipper.showNext();
                        } else if (currView == 3) {
                            flipper.setInAnimation(Voting.this, R.anim.slide_in_from_left);
                            flipper.setOutAnimation(Voting.this, R.anim.slide_out_to_right);
                            flipper.showPrevious();
                        }
                        currView = 2;
                        break;
                    default:
                        if (currView == 1) {
                            flipper.setInAnimation(Voting.this, R.anim.slide_in_from_far_right);
                            flipper.setOutAnimation(Voting.this, R.anim.slide_out_to_far_left);
                            flipper.showPrevious();
                        } else if (currView == 2) {
                            flipper.setInAnimation(Voting.this, R.anim.slide_in_from_right);
                            flipper.setOutAnimation(Voting.this, R.anim.slide_out_to_left);
                            flipper.showNext();
                        }
                        currView = 3;
                }
            }
        };
        findViewById(R.id.ButtonLeberkaese).setOnClickListener(buttonListener);
        findViewById(R.id.ButtonWuerstel).setOnClickListener(buttonListener);
        findViewById(R.id.ButtonWurst).setOnClickListener(buttonListener);
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
        int i;
        Resources resources = getResources();
        String[] sorten = resources.getStringArray(R.array.sorten);
        for (i = 0; i < sorten.length; ++i) {
            RatingBar bar = (RatingBar) findViewById(
                    resources.getIdentifier("RatingBar" + sorten[i], "id", getPackageName())
            );
            if (bar.getRating() > 0)
                break;
        }
        if (i == sorten.length) {
            backToHome();
            currView = 1;
            finish();
            return;
        }
        new AlertDialog.Builder(this)
                .setTitle("Bewertungen beibehalten?")
                .setMessage("Wie soll mit den vorgenommenen Bewertungen verfahren werden?")
                .setPositiveButton("Beibehalten", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        backToHome();
                    }
                })
                .setNegativeButton("Verwerfen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        backToHome();
                        currView = 1;
                        finish();
                    }
                })
                .show();
    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.zurueck_Voting_1 || id == R.id.zurueck_Voting_2 || id == R.id.zurueck_Voting_3) {
            onBackPressed();
        } else {
            boolean any_bew_leb = false, any_bew_wue = false, any_bew_wur = false;
            int[] bew_leberkaese = new int[13], bew_wuerstel = new int[9], bew_wurst = new int[6];
            ArrayList[] keys_leberkaese = new ArrayList[5];
            ArrayList[] keys_wuerstel = new ArrayList[5];
            ArrayList[] keys_wurst = new ArrayList[5];
            for (int i = 0; i < 5; ++i) {
                keys_leberkaese[i] = new ArrayList();
                keys_wuerstel[i] = new ArrayList();
                keys_wurst[i] = new ArrayList();
            }
            Resources resources = getResources();
            String[] sorten = resources.getStringArray(R.array.sorten);
            for (int i = 0; i < sorten.length; ++i) {
                RatingBar bar = (RatingBar) findViewById(
                        resources.getIdentifier("RatingBar" + sorten[i], "id", getPackageName())
                );
                int rating = (int) bar.getRating();
                if (i < 13) {
                    bew_leberkaese[i] = rating;
                    any_bew_leb = true;
                } else if (i < 22) {
                    bew_wuerstel[i - 13] = rating;
                    any_bew_wue = true;
                } else {
                    bew_wurst[i - 22] = rating;
                    any_bew_wur = true;
                }
            }
            Log.e("bla", Arrays.toString(bew_leberkaese));
            Log.e("bla", Arrays.toString(bew_wuerstel));
            Log.e("bla", Arrays.toString(bew_wurst));

            Intent intent = new Intent(this, VotingSubmit.class);
            intent.putExtra("bew_leberkaese", bew_leberkaese);
            intent.putExtra("bew_wuerstel", bew_wuerstel);
            intent.putExtra("bew_wurst", bew_wurst);
            startActivity(intent);
        }
    }

    private void backToHome() {
        Intent intent = new Intent(Voting.this, Homescreen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

}