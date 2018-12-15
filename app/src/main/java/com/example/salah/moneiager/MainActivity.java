package com.example.salah.moneiager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     // Button b = findViewById(R.id.button);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,History.class);
                startActivity(i);
                Toast.makeText(MainActivity.this,"Home Clicked",Toast.LENGTH_SHORT).show();

            }
        });

    }


    public void gotoHistory(View view) {
        Intent i = new Intent(this,History.class);
        startActivity(i);
        Toast.makeText(this,"History Clicked",Toast.LENGTH_SHORT).show();

            }
}
