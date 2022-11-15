package com.example.skorbola;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageView satuImage, duaImage;
    EditText satuText, duaText;
    Uri imageUri1;
    Uri imageUri2;
    Bitmap bitmap1;
    Bitmap bitmap2;
    private static final String TAG = MainActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        satuImage = findViewById(R.id.satu_logo);
        satuText = findViewById(R.id.satu_team);
        duaImage = findViewById(R.id.dua_logo);
        duaText = findViewById(R.id.dua_team);
    }


    public void handleSatuLogo(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);
    }


    public void handleDuaLogo(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 2);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            return;
        }
        if (requestCode == 1) {
            if (data != null) {
                try {
                    imageUri1 = data.getData();
                    bitmap1 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri1);
                    satuImage.setImageBitmap(bitmap1);
                } catch (IOException e) {
                    Toast.makeText(this, "Tidak Bisa memuat gambar", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        } else if (requestCode == 2) {
            if (data != null) {
                try {
                    imageUri2 = data.getData();
                    bitmap2 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri2);
                    duaImage.setImageBitmap(bitmap2);
                } catch (IOException e) {
                    Toast.makeText(this, "Tidak Bisa memuat gambar", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }




    public void HandleSubmit(View view) {
        String inputSatu = satuText.getText().toString();
        String inputDua = duaText.getText().toString();
        if (!inputSatu.equals("") && !inputDua.equals("") && bitmap1 != null && bitmap2 != null) {
            Intent intent = new Intent(this, MatchActivity.class);
            intent.putExtra("inputSatu", inputSatu);
            intent.putExtra("logoSatu", imageUri1.toString());
            intent.putExtra("inputDua", inputDua);
            intent.putExtra("logoDua", imageUri2.toString());

            startActivity(intent);

        }else {
            Toast.makeText(this, "Nama Tim Belum diisi", Toast.LENGTH_SHORT).show();
        }
    }















}