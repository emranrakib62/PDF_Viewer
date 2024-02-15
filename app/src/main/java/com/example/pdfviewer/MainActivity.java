package com.example.pdfviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;

public class MainActivity extends AppCompatActivity {

    PDFView pdfView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdfView=findViewById(R.id.pdfView);


        pdfView.setVisibility(View.GONE);
pdfView.fromAsset("algorithom.pdf")
        .onLoad(new OnLoadCompleteListener() {
            @Override
            public void loadComplete(int nbPages) {
                pdfView.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "Loaded", Toast.LENGTH_SHORT).show();
            }
        })
        .load();



    }
}