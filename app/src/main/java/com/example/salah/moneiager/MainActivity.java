package com.example.salah.moneiager;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper db ;
    private TextView tx1;
    private TextView tx2;
    TextView tx3;
    FloatingActionButton faBu;
    List<UserInfo> l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DataBaseHelper(this);
        EditText description;
        l = db.getUser();

        if (l.isEmpty()) {
            Intent i = new Intent(this, OnCreateActivity.class);
            startActivity(i);

        } else {

            tx1 = (TextView) findViewById(R.id.IncomeValue);
            tx1.setText(l.get(0).getUserIncome() + "TL  100%");

            tx2 = (TextView) findViewById(R.id.UsedValue);
            tx2.setText("    "+db.getSumPrice() + "TL  " + (100 * db.getSumPrice()) / l.get(0).getUserIncome() + "%");

            tx3 = (TextView) findViewById(R.id.AvaliableValue);
            tx3.setText(l.get(0).getUserIncome() - db.getSumPrice() + "TL  " + (100 - ((100 * db.getSumPrice()) / l.get(0).getUserIncome())) + "%");

            faBu = (FloatingActionButton) findViewById(R.id.floatingActionButton);
            faBu.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                    View myView = getLayoutInflater().inflate(R.layout.layout_insert_item, null);

                    final EditText description = (EditText) myView.findViewById(R.id.edDescription);
                    final EditText price = (EditText) myView.findViewById(R.id.edprice);
                    Button bu = (Button) myView.findViewById(R.id.addBut);

                    bu.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            if (description.getText().toString().isEmpty() || price.getText().toString().isEmpty()) {
                                Toast.makeText(MainActivity.this, "fill all fields please", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            db.addItem(description.getText().toString(), Integer.parseInt(price.getText().toString()));
                            startActivity(MainActivity.this.getIntent());

                        }
                    });

                    mBuilder.setView(myView);
                    AlertDialog dialog = mBuilder.create();
                    dialog.show();

                }
            });

        }
    }


    public void gotoHistory(View view) {
        Intent i = new Intent(this,History.class);
        startActivity(i);

            }


            public void clearHistory(View view){
                Intent i = new Intent(MainActivity.this, AllHestory.class);
                startActivity(i);
            }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        moveTaskToBack(true);
    }

    @Override
    public void onRestart() {
        super.onRestart();
        startActivity(getIntent());

    }



}
