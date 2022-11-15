package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class MatchActivity extends AppCompatActivity {

    TextView homeName;
    TextView awayName;
    TextView awayScore;
    TextView homeScore;
    ImageView homeLogo;
    ImageView awayLogo;
    Uri uri1;
    Uri uri2;
    Bitmap bitmap1;
    Bitmap bitmap2;
    String homeTeam;
    String awayTeam;
    int scoreHome = 0;
    int scoreAway = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        homeName = findViewById(R.id.txt_home);
        awayName = findViewById(R.id.txt_away);
        homeLogo = findViewById(R.id.home_logo);
        awayLogo = findViewById(R.id.away_logo);
        awayScore = findViewById(R.id.score_away);
        homeScore = findViewById(R.id.score_home);

        Bundle extras = getIntent().getExtras();
        homeTeam = extras.getString("inputHome");
        awayTeam = extras.getString("inputAway");

        if(extras != null){
            uri1 = Uri.parse(extras.getString("logoHome"));
            uri2 = Uri.parse(extras.getString("logoAway"));
            bitmap1 = null;
            bitmap2 = null;

            try{
                bitmap1 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri1);
                bitmap2 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri2);
            }catch(IOException e){
                e.printStackTrace();
            }

            homeName.setText(homeTeam);
            awayName.setText(awayTeam);
            homeLogo.setImageBitmap(bitmap1);
            awayLogo.setImageBitmap(bitmap2);
        }
    }


    public void handleHome(View view){
        scoreHome = scoreHome + 1;
        homeScore.setText(String.valueOf(scoreHome));
    }

    public void handleHome2(View view){
        scoreHome = scoreHome + 2;
        homeScore.setText(String.valueOf(scoreHome));
    }

    public void handleHome3(View view){
        scoreHome = scoreHome + 3;
        homeScore.setText(String.valueOf(scoreHome));
    }

    public void handleHome4(View view){
        scoreHome = 0;
        homeScore.setText(String.valueOf(scoreHome));
    }

    public void handleAway(View view){
        scoreAway = scoreAway + 1;
        awayScore.setText(String.valueOf(scoreAway));
    }

    public void handleAway2(View view){
        scoreAway = scoreAway + 2;
        awayScore.setText(String.valueOf(scoreAway));
    }

    public void handleAway3(View view){
        scoreAway = scoreAway + 3;
        awayScore.setText(String.valueOf(scoreAway));
    }

    public void handleAway4(View view){
        scoreAway = 0;
        awayScore.setText(String.valueOf(scoreAway));
    }

    public void hasil(View view){
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("homeScore", scoreHome);
        intent.putExtra("awayScore", scoreAway);
        intent.putExtra("homeName", homeTeam);
        intent.putExtra("awayName", awayTeam);

        startActivity(intent);
    }
}
