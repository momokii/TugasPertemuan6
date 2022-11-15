package com.example.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Hasil extends AppCompatActivity {

    TextView hasil;
    TextView pemenang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        hasil = findViewById(R.id.skor);
        pemenang = findViewById(R.id.hasil);


        Bundle extras = getIntent().getExtras();
        int satuHasil = extras.getInt("satuScore");
        int duaHasil = extras.getInt("duaScore");
        String satuName = extras.getString("satuName");
        String duaName = extras.getString("duaName");




        if(extras != null ){
            hasil.setText("Hasil Akhir Pertandingan : "+ satuName + ":" +String.valueOf(satuHasil) + " - " + duaName + ":" + String.valueOf(duaHasil));
            if(satuHasil > duaHasil){
                pemenang.setText("Tim "+ satuName + " Menang!");
            }else if(duaHasil > satuHasil){
                pemenang.setText("Tim "+ duaName + " Menang!");
            }else{
                pemenang.setText("Skor Imbang!");
            }
        }




    }
}