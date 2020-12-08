package com.example.tobboldalasalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonKules;
    private EditText editTextBemenet;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        buttonKules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String adat = editTextBemenet.getText().toString();
                editor.putString("nev", adat);
                editor.commit();

                if (editor.commit()){
                    Toast.makeText(MainActivity.this, "Sikeres adatfelvétel!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Sikertelen adatfelvétel!", Toast.LENGTH_SHORT).show();
                }

                Intent masodikActivity = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(masodikActivity);
                finish();
            }
        });
    }

    public void init(){
        buttonKules = findViewById(R.id.buttonKuldes);
        editTextBemenet = findViewById(R.id.editTextBemenet);

        sharedPreferences = getSharedPreferences("adatok", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }
}