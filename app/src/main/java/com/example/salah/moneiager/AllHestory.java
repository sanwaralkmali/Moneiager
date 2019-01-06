package com.example.salah.moneiager;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AllHestory extends AppCompatActivity {
    DataBaseHelper db;

    List<historyModel> list = new ArrayList<>();
    MyCustomerAdaptor myCustomerAdaptor;
    ListView lvList;
    Button reset;
    Button newSession;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_hestory);

        db = new DataBaseHelper(this);


        list = db.getAllNotes();
        lvList = (ListView) findViewById(R.id.historyList);
        myCustomerAdaptor = new MyCustomerAdaptor();
        lvList.setAdapter(myCustomerAdaptor);

        reset = (Button) findViewById(R.id.resetHistory);
        reset.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AllHestory.this);

                builder.setTitle("Confirm");
                builder.setMessage("Are you sure?");
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        db.deleteAll();
                        startActivity(getIntent());
                        finish();
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });

                AlertDialog alert =builder.create();
                alert.show();
            }
        });

        newSession = (Button) findViewById(R.id.newSession);
        newSession.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AllHestory.this);

                builder.setTitle("Confirm");
                builder.setMessage("Are you sure?");
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        db.deleteUser();
                        startActivity(new Intent(AllHestory.this,MainActivity.class));

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });

                AlertDialog alert =builder.create();
                alert.show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,MainActivity.class));
    }

    public class MyCustomerAdaptor extends BaseAdapter {


        @Override
        public int getCount() {
            return list.size();

        }

        @Override
        public String getItem(int postion) {
            return null;
        }

        @Override
        public long getItemId(int postion) {
            return postion;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater mInflater = getLayoutInflater();

            View view = mInflater.inflate(R.layout.listview_history, null);

            historyModel s = list.get(position);

            TextView txDate = (TextView) view.findViewById(R.id.Date);
            TextView txDescription = (TextView) view.findViewById(R.id.Description);
            TextView txPrice = (TextView) view.findViewById(R.id.Price);
            txDate.setText(s.getTimestamp());
            txDescription.setText(s.getdescription());
            txPrice.setText(String.valueOf(s.getPrice()));

            return view;

        }


    }

}
