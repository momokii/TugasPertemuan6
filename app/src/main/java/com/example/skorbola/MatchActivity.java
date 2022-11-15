package com.example.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class MatchActivity extends AppCompatActivity {

    TextView satuName;
    TextView satuScore;
    ImageView satuLogo;
    Uri uri1;
    Bitmap bitmap1;
    String satuTeam;
    int scoreSatu = 0;

    TextView duaName;
    TextView duaScore;
    ImageView duaLogo;
    Uri uri2;
    Bitmap bitmap2;
    String duaTeam;
    int scoreDua = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);


        satuName = findViewById(R.id.txt_satu);
        satuLogo = findViewById(R.id.satu_logo);
        satuScore = findViewById(R.id.score_satu);
        duaName = findViewById(R.id.txt_dua);
        duaLogo = findViewById(R.id.dua_logo);
        duaScore = findViewById(R.id.score_dua);

        Bundle extras = getIntent().getExtras();
        satuTeam = extras.getString("inputSatu");
        duaTeam = extras.getString("inputDua");

        if(extras != null) {
            uri1 = Uri.parse(extras.getString("logoSatu"));
            uri2 = Uri.parse(extras.getString("logoDua"));
            bitmap1 = null;
            bitmap2 = null;

            try {
                bitmap1 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri1);
                bitmap2 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri2);
            } catch (IOException e) {
                e.printStackTrace();
            }

            satuName.setText(satuTeam);
            duaName.setText(duaTeam);
            satuLogo.setImageBitmap(bitmap1);
            duaLogo.setImageBitmap(bitmap2);

        }

    }


    public void handleSatu(View view){
        scoreSatu = scoreSatu + 1;
        satuScore.setText(String.valueOf(scoreSatu));
    }

    public void handleSatuReset(View view){
        scoreSatu = 0;
        satuScore.setText(String.valueOf(scoreSatu));
    }

    public void handleDua(View view){
        scoreDua = scoreDua + 1;
        duaScore.setText(String.valueOf(scoreDua));
    }

    public void handleDuaReset(View view){
        scoreDua = 0;
        duaScore.setText(String.valueOf(scoreDua));
    }


    public void hasil(View view){
        Intent intent = new Intent(this, Hasil.class);
        intent.putExtra("satuScore", scoreSatu);
        intent.putExtra("duaScore", scoreDua);
        intent.putExtra("satuName", satuTeam);
        intent.putExtra("duaName", duaTeam);

        startActivity(intent);
    }











}