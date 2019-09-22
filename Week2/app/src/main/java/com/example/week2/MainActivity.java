package com.example.week2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    TextView txtView ;
    private EditText mWebsiteEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView = findViewById(R.id.etNo);

        findViewById(R.id.btnCamera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(i);
            }
        });
//        final EditText et = (EditText) findViewById(R.id.etNo);
        mWebsiteEditText = findViewById(R.id.btnTextBrowser);

        findViewById(R.id.btnBrowser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = mWebsiteEditText.getText().toString();
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
            }
        });

        findViewById(R.id.btnMap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(getIntent().ACTION_VIEW);
                i.setData(Uri.parse("http://maps.google.com/maps/"));
                startActivity((i));
            }
        });
        findViewById(R.id.btnMessage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings = {"deepak.pradhan048@gmail.com"};
                Intent i = new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_TEXT, txtView.getText().toString());
                i.putExtra(Intent.EXTRA_EMAIL, strings);
                i.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                i.setType("text/plain");

                Intent shareIntent = Intent.createChooser(i, null);
                startActivity(shareIntent);
            }
        });
    }

}
