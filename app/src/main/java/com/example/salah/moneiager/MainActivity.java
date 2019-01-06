package com.example.salah.moneiager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper db ;
    TextView tx1;
    TextView tx2;
    TextView tx3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DataBaseHelper(this);

        List<UserInfo> l = db.getUser();

        if(l.isEmpty())
        {
            Intent i = new Intent(this,OnCreateActivity.class);
            startActivity(i);

        }
        tx1 = (TextView)findViewById(R.id.IncomeValue);
        tx1.setText(l.get(0).getUserIncome() + "TL      100%");

        tx2 = (TextView)findViewById(R.id.UsedValue);
        tx2.setText(db.getSumPrice() + " TL       " + (100*db.getSumPrice())/l.get(0).getUserIncome() +"%");

        tx3 = (TextView)findViewById(R.id.AvaliableValue);
        tx3.setText(l.get(0).getUserIncome()-db.getSumPrice() + "TL     " + (100-((100*db.getSumPrice())/l.get(0).getUserIncome())) +"%");


    }



    public void gotoHistory(View view) {
        Intent i = new Intent(this,History.class);
        startActivity(i);
        Toast.makeText(this,"History Clicked",Toast.LENGTH_SHORT).show();

            }
}
