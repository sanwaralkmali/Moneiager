package com.example.salah.moneiager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ContinueActivity extends AppCompatActivity {
    EditText userIncome;
    EditText userMax;
    EditText itemMax;
    EditText toKeep;
    Bundle b;
    DataBaseHelper db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);
         b = getIntent().getExtras();
         db = new DataBaseHelper(this);

         userIncome = (EditText) findViewById(R.id.UserIncome);
         userMax = (EditText) findViewById(R.id.MaxExponses);
         itemMax = (EditText) findViewById(R.id.ItemMax);
         toKeep = (EditText) findViewById(R.id.ToKeep);

    }
    public void SubmitClick(View view) {

        if(userIncome.getText().toString().isEmpty() || userMax.getText().toString().isEmpty()
                || itemMax.getText().toString().isEmpty() || toKeep.getText().toString().isEmpty()){
            Toast.makeText(this,"all feilds are required",Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
        db.insertUser(b.getString("userName"),b.getString("userEmail"),
               Integer.parseInt(userIncome.getText().toString()), Integer.parseInt(userMax.getText().toString())
                , Integer.parseInt(itemMax.getText().toString()), Integer.parseInt(toKeep.getText().toString()));

        Intent intent = new Intent(ContinueActivity.this,MainActivity.class);
        startActivity(intent);

        }


    }

}
