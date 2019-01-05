package com.example.salah.moneiager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void gotoHistory(View view) {
        Intent i = new Intent(this,History.class);
        startActivity(i);
        Toast.makeText(this,"History Clicked",Toast.LENGTH_SHORT).show();

            }
}
