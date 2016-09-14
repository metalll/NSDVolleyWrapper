package application.nsd.nsdvolleywrapper.TestActivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;

import application.nsd.nsdvolleywrapper.R;
import application.nsd.nsdvolleywrapper.Wrapper.Interfaces.IAfterLoad;
import application.nsd.nsdvolleywrapper.Wrapper.NSDQueue;
import application.nsd.nsdvolleywrapper.Wrapper.NSDVolleyWrapper;

public class MainActivity extends Activity {

    android.support.v4.widget.ContentLoadingProgressBar progressBar;
    TextView webView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ContentLoadingProgressBar) findViewById(R.id.progress);
        webView = (TextView) findViewById(R.id.webView);

        progressBar.show();

        NSDQueue.InitWithActivity(this);
// initQueue
        RequestQueue queue = NSDQueue.getInstance().getQueue();
// без этого не работает!




        String url ="http://www.google.com";


        NSDVolleyWrapper.sendGet(url, new IAfterLoad(){
            @Override
            public void afterLoad(Object[] responce) {

                progressBar.hide();
                webView.setText((String) responce[0]);
                Toast.makeText(MainActivity.this,"Load success", Toast.LENGTH_LONG).show();
                // my "delegate" update UI
            }
        });



    }



}
