package com.example.happyme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    private Button buttonMantras;
    private Button buttonFamilyTime;
    private Button buttonMeTime;
    private Button buttonBoostUpTime;
    private Button buttonHappyTime;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        buttonMantras = (Button) findViewById(R.id.buttonMantras);
        buttonMantras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMantrasActivity();
            }
        });

        buttonFamilyTime = (Button) findViewById(R.id.buttonFamilyTime);
        buttonFamilyTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityFamilyTimeActivity();
            }
        });

        buttonMeTime = (Button) findViewById(R.id.buttonMeTime);
        buttonMeTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMeTimeActivity();
            }
        });

        buttonBoostUpTime = (Button) findViewById(R.id.buttonBoostUpTime);
        buttonBoostUpTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityBoostUpTimeActivity();
            }
        });

        buttonHappyTime = (Button) findViewById(R.id.buttonHappyTime);
        buttonHappyTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityHappyTimeActivity();
            }
        });
    }

    public void openActivityMantrasActivity() {
        Intent intent = new Intent(this, MantrasActivity.class);
        startActivity(intent);
    }

    public void openActivityFamilyTimeActivity() {
        Intent intent = new Intent(this, FamilyTimeActivity.class);
        startActivity(intent);
    }

    public void openActivityMeTimeActivity() {
        Intent intent = new Intent(this, MeTimeActivity.class);
        startActivity(intent);
    }

    public void openActivityBoostUpTimeActivity() {
        Intent intent = new Intent(this, BoostUpTimeActivity.class);
        startActivity(intent);
    }

    public void openActivityHappyTimeActivity() {
        Intent intent = new Intent(this, HappyTimeActivity.class);
        startActivity(intent);
    }


}
