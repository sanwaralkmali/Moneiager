package com.example.salah.moneiager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class OnCreateActivity extends AppCompatActivity {
    EditText userName;
    EditText userEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_create);

        userName = (EditText) findViewById(R.id.UserName);
        userEmail = (EditText) findViewById(R.id.UserEmail);
            }
    public void ContinueClick(View view) {
        if(userName.getText().toString().equals("") || userEmail.getText().toString().equals("")){
            Toast.makeText(this,"insert UserName and Email",Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {   Intent i = new Intent(this,ContinueActivity.class);
            Bundle b = new Bundle();
            b.putString("userName",userName.getText().toString());
            b.putString("userEmail",userEmail.getText().toString());

            i.putExtras(b);
            startActivity(i);
      }   }
   @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        moveTaskToBack(true);
    }

}
