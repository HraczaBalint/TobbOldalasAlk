package com.example.tobboldalasalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private Button buttonVissza;
    private TextView textViewKimenet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();

        buttonVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent elsoActivity = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(elsoActivity);
                finish();
            }
        });
    }

    public void init(){
        buttonVissza = findViewById(R.id.buttonVissza);
        textViewKimenet = findViewById(R.id.textKiemenet);

        SharedPreferences sharedPreferences = getSharedPreferences("adatok", Context.MODE_PRIVATE);

        textViewKimenet.setText(sharedPreferences.getString("nev", "Nincs ilyen érték"));
    }
}