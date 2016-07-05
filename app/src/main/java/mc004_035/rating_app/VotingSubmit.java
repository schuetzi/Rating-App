package mc004_035.rating_app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class VotingSubmit extends Activity implements View.OnClickListener {

    private boolean k_leb_empty = true, k_wue_empty = true, k_wur_empty = true;
    private boolean teilnbed_shown = false;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voting_submit);
        WebView teilnbed_view = (WebView) findViewById(R.id.teilnbed_view);
        teilnbed_view.loadUrl("file:///android_asset/teilnahmebedingungen.html");
        teilnbed_view.setBackgroundColor(0);
        intent = getIntent();
        findViewById(R.id.absenden).setOnClickListener(this);
        findViewById(R.id.zurueck_Absenden).setOnClickListener(this);
        findViewById(R.id.teilnbed).setOnClickListener(this);
        findViewById(R.id.zurueck_WebView_Button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.absenden) {
            if (!(((CheckBox) findViewById(R.id.gelesen)).isChecked() && ((EditText) findViewById(R.id.email)).getText().toString().trim().length() > 0))
                new AlertDialog.Builder(this)
                        .setTitle("Fehler:")
                        .setMessage("Bitte geben Sie Ihre E-Mail-Adresse an und akzeptieren Sie die Teilnahmebedingungen.")
                        .setNeutralButton("OK", null)
                        .show();
            else {
                final Handler mHandler = new Handler() {
                    public void handleMessage(Message msg) {
                        if (msg.what == 0) {
                            new AlertDialog.Builder(VotingSubmit.this)
                                    .setTitle("Danke!")
                                    .setMessage("Vielen Dank für Ihre Teilnahme am gourmetfein-Gewinnspiel.\nSie haben soeben eine E-Mail erhalten.")
                                    .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent i = new Intent(VotingSubmit.this, Homescreen.class);
                                            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            VotingSubmit.this.startActivity(i);
                                        }
                                    })
                                    .setCancelable(false)
                                    .show();
                        } else
                            new AlertDialog.Builder(VotingSubmit.this)
                                    .setTitle("Fehler:")
                                    .setMessage("Es ist ein technisches Problem aufgetreten.\nBitte wenden Sie sich an eine/-n gourmetfein-Mitarbeiter/-in.")
                                    .setNeutralButton("OK", null)
                                    .show();
                    }
                };
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String response = "";
                            URL url = new URL("http://nms.schule-agatha.at/gourmetfein/gourmetfein_mail");

                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setReadTimeout(15000);
                            conn.setConnectTimeout(15000);
                            conn.setRequestMethod("POST");
                            conn.setDoInput(true);
                            conn.setDoOutput(true);

                            OutputStream os = conn.getOutputStream();
                            BufferedWriter writer = new BufferedWriter(
                                    new OutputStreamWriter(os, "UTF-8"));
                            HashMap map = new HashMap();
                            map.put("email", ((EditText) findViewById(R.id.email)).getText().toString());
                            if (((EditText) findViewById(R.id.firma)).getText().toString().trim().length() > 0)
                                map.put("firma", ((EditText) findViewById(R.id.firma)).getText().toString());
                            int geschlecht = 0;
                            if (((RadioButton) findViewById(R.id.maennlich)).isChecked())
                                geschlecht = 1;
                            else if (((RadioButton) findViewById(R.id.weiblich)).isChecked())
                                geschlecht = 2;
                            String vorname = ((EditText) findViewById(R.id.vorname)).getText().toString().trim();
                            String nachname = ((EditText) findViewById(R.id.nachname)).getText().toString().trim();
                            if (vorname.length() > 0)
                                map.put("vorname", vorname);
                            if (nachname.length() > 0)
                                map.put("nachname", nachname);
                            if (geschlecht > 0 && nachname.length() > 0)
                                if (geschlecht == 1)
                                    map.put("grussformel", "Sehr geehrter Herr " + nachname + "!");
                                else
                                    map.put("grussformel", "Sehr geehrte Frau " + nachname + "!");
                            if (((EditText) findViewById(R.id.strasse)).getText().toString().trim().length() > 0)
                                map.put("strasse", ((EditText) findViewById(R.id.strasse)).getText().toString());
                            if (((EditText) findViewById(R.id.ort)).getText().toString().trim().length() > 0)
                                map.put("ort", ((EditText) findViewById(R.id.ort)).getText().toString());
                            if (((EditText) findViewById(R.id.land)).getText().toString().trim().length() > 0)
                                map.put("land", ((EditText) findViewById(R.id.land)).getText().toString());
                            if (((EditText) findViewById(R.id.nummer)).getText().toString().trim().length() > 0)
                                map.put("nummer", ((EditText) findViewById(R.id.nummer)).getText().toString());
                            int[] bew_leberkaese = intent.getIntArrayExtra("bew_leberkaese");
                            int[] bew_wuerstel = intent.getIntArrayExtra("bew_wuerstel");
                            int[] bew_wurst = intent.getIntArrayExtra("bew_wurst");
                            for (int i = 0; i < 13; ++i)
                                if (bew_leberkaese[i] != 0)
                                    k_leb_empty = false;
                            for (int i = 0; i < 9; ++i)
                                if (bew_wuerstel[i] != 0)
                                    k_wue_empty = false;
                            for (int i = 0; i < 6; ++i)
                                if (bew_wurst[i] != 0)
                                    k_wur_empty = false;
                            if (!k_leb_empty)
                                    map.put("bew_leberkaese_str", Arrays.toString(bew_leberkaese));
                            if (!k_wue_empty)
                                    map.put("bew_wuerstel_str", Arrays.toString(bew_wuerstel));
                            if (!k_wur_empty)
                                    map.put("bew_wurst_str", Arrays.toString(bew_wurst));
                            writer.write(getPostDataString(map));

                            writer.flush();
                            writer.close();
                            os.close();
                            int responseCode = conn.getResponseCode();

                            if (responseCode == HttpsURLConnection.HTTP_OK) {
                                String line;
                                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                                while ((line = br.readLine()) != null) {
                                    response += line;
                                }
                                mHandler.sendEmptyMessage(0);
                            } else
                                response = "";
                        } catch (Exception e) {
                            Log.e("bla", e.toString());
                            mHandler.sendEmptyMessage(1);
                        }
                    }
                });
                thread.start();
            }
        }
                else if (v.getId() == R.id.teilnbed) {
                    findViewById(R.id.layout).setVisibility(View.INVISIBLE);
                    findViewById(R.id.teilnbed_view).setVisibility(View.VISIBLE);
                    findViewById(R.id.zurueckWebView).setVisibility(View.VISIBLE);
                    teilnbed_shown = true;
                } else if (v.getId() == R.id.zurueck_Absenden) {
                    finish();
                } else if (v.getId() == R.id.zurueck_WebView_Button) {
                    findViewById(R.id.layout).setVisibility(View.VISIBLE);
                    findViewById(R.id.teilnbed_view).setVisibility(View.INVISIBLE);
                    findViewById(R.id.zurueckWebView).setVisibility(View.INVISIBLE);
                    teilnbed_shown = false;
                }
            }

    private String format(String sorte) {
        StringBuffer buffer = new StringBuffer(sorte);
        buffer.setCharAt(0, Character.toLowerCase(buffer.charAt(0)));
        int length = buffer.length();
        for (int i = 0; i < length; ++i)
            if (buffer.charAt(i) == Character.toUpperCase(buffer.charAt(i))) {
                buffer.setCharAt(i, Character.toLowerCase(buffer.charAt(i)));
                buffer.insert(i, '_');
                ++i;
            }
        return buffer.toString();
    }

    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String, String> entry : params.entrySet()){
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }

    @Override
    public void onBackPressed() {
        if (teilnbed_shown)
            findViewById(R.id.zurueck_WebView_Button).performClick();
        else
            finish();
    }

}