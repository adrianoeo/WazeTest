package wazetest.com.aeo.wazetest;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        String url = "waze://?ll=%s&navigate=yes";
        switch (view.getId()) {
            case R.id.btnHome:
                url = String.format(url, "-22.812121, -47.024328");
                break;
            case R.id.btnWork:
                url = String.format(url, "-22.897157, -47.101876");
                break;
            case R.id.btnHomeMom:
                url = String.format(url, "-22.869306, -47.060993");
                break;
            case R.id.btnHomeSogra:
                url = String.format(url, "-22.874064, -47.032733");
                break;
        }

        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            Intent intent =
                    new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.waze"));
            startActivity(intent);
        }
    }
}
