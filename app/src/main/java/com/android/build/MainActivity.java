package com.android.build;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_chanel);

        try {
            ApplicationInfo info = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);

            String metaChannel = info.metaData.getString("CHANNEL_ID");
            textView.setText("Channel Id : " + metaChannel);


            Log.e(TAG, metaChannel);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();

            textView.setText("Channel Id : " + e.getMessage());
        }


    }
}
