package eu.gruessung.arnoldi;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity
{

    private WebView mWebview;

    private String[] arraySpinner;

    private Spinner s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        mWebview = (WebView) findViewById(R.id.webView);

        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

        final Activity activity = this;

        mWebview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

        mWebview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);


        this.arraySpinner = new String[] {
                "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag"
        };
        s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        s.setAdapter(adapter);

        mWebview .loadUrl("http://www.arnoldi-gym.de/vplan/montag.htm");

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position)
                {
                    case 0:
                        mWebview.loadUrl("http://www.arnoldi-gym.de/vplan/montag.htm");
                        break;
                    case 1:
                        mWebview.loadUrl("http://www.arnoldi-gym.de/vplan/dienstag.htm");
                        break;
                    case 2:
                        mWebview.loadUrl("http://www.arnoldi-gym.de/vplan/mittwoch.htm");
                        break;
                    case 3:
                        mWebview.loadUrl("http://www.arnoldi-gym.de/vplan/donnerstag.htm");
                        break;
                    case 4:
                        mWebview.loadUrl("http://www.arnoldi-gym.de/vplan/freitag.htm");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }


}
